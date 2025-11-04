package com.strivers.arrays.easy;

import java.util.*;
class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> available;
    private Map<String, Integer> priceMap;
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        priceMap = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2])
                return a[2] - b[2];
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(key(shop, movie), price);
            available.computeIfAbsent(movie, k -> new TreeSet<>((x, y) -> {
                if (x[1] != y[1])
                    return x[1] - y[1];
                return x[0] - y[0];
            })).add(new int[] { shop, price });
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie))
            return res;
        Iterator<int[]> it = available.get(movie).iterator();
        while (it.hasNext() && res.size() < 5) {
            res.add(it.next()[0]);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        available.get(movie).remove(new int[] { shop, price });
        rented.add(new int[] { shop, movie, price });
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        rented.remove(new int[] { shop, movie, price });
        available.get(movie).add(new int[] { shop, price });
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        while (it.hasNext() && res.size() < 5) {
            int[] r = it.next();
            res.add(Arrays.asList(r[0], r[1]));
        }
        return res;
    }

    private String key(int shop, int movie) {
        return shop + "," + movie;
    }
}
class Router {
    private int memoryLimit;
    private Deque<int[]> queue;
    private Set<String> packetSet;
    private Map<Integer, Deque<Integer>> destMap;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false;

        if (queue.size() == memoryLimit) {
            int[] old = queue.pollFirst();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            packetSet.remove(oldKey);

            Deque<Integer> dq = destMap.get(old[1]);
            dq.pollFirst();
            if (dq.isEmpty()) destMap.remove(old[1]);
        }

        int[] packet = new int[]{source, destination, timestamp};
        queue.offerLast(packet);
        packetSet.add(key);

        destMap.putIfAbsent(destination, new ArrayDeque<>());
        destMap.get(destination).offerLast(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        int[] packet = queue.pollFirst();
        String key = packet[0] + "#" + packet[1] + "#" + packet[2];
        packetSet.remove(key);

        Deque<Integer> dq = destMap.get(packet[1]);
        dq.pollFirst();
        if (dq.isEmpty()) destMap.remove(packet[1]);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;

        Deque<Integer> dq = destMap.get(destination);
        List<Integer> list = new ArrayList<>(dq);
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    private int lowerBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= val) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > val) r = m;
            else l = m + 1;
        }
        return l;
    }
}

class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int val1 = parseValue(parts[0]);
        int val2 = parseValue(parts[1]);
        return val1 + val2;
    }

    private int parseValue(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        } else {
            int[] pos = parseCell(s);
            return grid[pos[0]][pos[1]];
        }
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[] { row, col };
    }
}
class TaskManager {
    private Map<Integer, int[]> taskMap;
    private PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{taskId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int[] userPriority = taskMap.get(taskId);
        userPriority[1] = newPriority;
        taskMap.put(taskId, userPriority);
        pq.offer(new int[]{taskId, newPriority});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int taskId = top[0], priority = top[1];
            if (taskMap.containsKey(taskId)) {
                int[] userPriority = taskMap.get(taskId);
                if (userPriority[1] == priority) {
                    taskMap.remove(taskId);
                    return userPriority[0];
                }
            }
        }
        return -1;
    }
}

class Bank {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (var e : map.entrySet()) {
                list.add(new int[] { e.getKey(), e.getValue() });
            }
            list.sort((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
            Set<Integer> keep = new HashSet<>();
            for (int t = 0; t < Math.min(x, list.size()); t++)
                keep.add(list.get(t)[0]);
            int sum = 0;
            for (int j = i; j < i + k; j++)
                if (keep.contains(nums[j]))
                    sum += nums[j];
            ans[i] = sum;
        }
        return ans;
    }
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return totalTime;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] w : walls)
            grid[w[0]][w[1]] = 2;
        for (int[] g : guards)
            grid[g[0]][g[1]] = 1;
        for (int[] g : guards) {
            for (int i = g[0] - 1; i >= 0 && grid[i][g[1]] != 1 && grid[i][g[1]] != 2; i--)
                if (grid[i][g[1]] == 0)
                    grid[i][g[1]] = 3;
            for (int i = g[0] + 1; i < m && grid[i][g[1]] != 1 && grid[i][g[1]] != 2; i++)
                if (grid[i][g[1]] == 0)
                    grid[i][g[1]] = 3;
            for (int j = g[1] - 1; j >= 0 && grid[g[0]][j] != 1 && grid[g[0]][j] != 2; j--)
                if (grid[g[0]][j] == 0)
                    grid[g[0]][j] = 3;
            for (int j = g[1] + 1; j < n && grid[g[0]][j] != 1 && grid[g[0]][j] != 2; j++)
                if (grid[g[0]][j] == 0)
                    grid[g[0]][j] = 3;
        }
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    res++;
        return res;
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return dummy.next;
    }
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n];
        int[] res = new int[2];
        int idx = 0;
        for (int num : nums) {
            if (seen[num])
                res[idx++] = num;
            else
                seen[num] = true;
        }
        return res;
    }
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1])
                res += target[i] - target[i - 1];
        }
        return res;
    }
    public int smallestNumber(int n) {
        int x = 1;
        while ((1 << x) - 1 < n)
            x++;
        return (1 << x) - 1;
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int[] a = nums.clone();
                if (simulate(a.clone(), i, 1))
                    res++;
                if (simulate(a.clone(), i, -1))
                    res++;
            }
        }
        return res;
    }

    private boolean simulate(int[] nums, int curr, int dir) {
        int n = nums.length;
        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0)
                curr += dir;
            else {
                nums[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int x : nums)
            if (x != 0)
                return false;
        return true;
    }
    public int numberOfBeams(String[] bank) {
        int prev = 0, total = 0;
        for (String row : bank) {
            int devices = 0;
            for (char c : row.toCharArray())
                if (c == '1')
                    devices++;
            if (devices > 0) {
                total += prev * devices;
                prev = devices;
            }
        }
        return total;
    }
    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2) || balance[account1 - 1] < money)
            return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account))
            return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account) || balance[account - 1] < money)
            return false;
        balance[account - 1] -= money;
        return true;
    }

    private boolean valid(int account) {
        return account >= 1 && account <= balance.length;
    }
}
public class ZerosLast {
    public static int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;
        total += 28 * weeks + 7 * (weeks * (weeks - 1)) / 2;
        total += (weeks + 1 + weeks + days) * days / 2;
        return total;
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1;; i++)
            if (isBalanced(i))
                return i;
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        for (char c : String.valueOf(num).toCharArray())
            count[c - '0']++;
        for (int d = 0; d < 10; d++)
            if (count[d] != 0 && count[d] != d)
                return false;
        return true;
    }
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int sum = (s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10;
                t.append(sum);
            }
            s = t.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
    public int maxFrequency1(int[] nums, int k, int numOperations) {
        Map<Long, Integer> startEnd = new TreeMap<>();
        Map<Long, Integer> countExact = new HashMap<>();
        for (int v : nums) {
            long start = (long) v - k;
            long end = (long) v + k + 1;
            startEnd.put(start, startEnd.getOrDefault(start, 0) + 1);
            startEnd.put(end, startEnd.getOrDefault(end, 0) - 1);
            countExact.put((long) v, countExact.getOrDefault((long) v, 0) + 1);
        }

        long current = 0;
        int result = 1;
        for (Map.Entry<Long, Integer> e : startEnd.entrySet()) {
            long x = e.getKey();
            current += e.getValue();
            int already = countExact.getOrDefault(x, 0);
            int possible = (int) Math.min(current, (long) already + numOperations);
            result = Math.max(result, possible);
        }
        return result;
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxV = 0;
        for (int v : nums)
            maxV = Math.max(maxV, v);
        int size = maxV + k + 1;
        int[] freq = new int[size];
        for (int v : nums)
            freq[v]++;
        int[] pref = new int[size + 1];
        for (int i = 0; i < size; i++)
            pref[i + 1] = pref[i] + freq[i];
        int res = 0;
        for (int t = 0; t < size; t++) {
            int left = Math.max(0, t - k);
            int right = Math.min(size - 1, t + k);
            int totalInRange = pref[right + 1] - pref[left];
            int already = freq[t];
            int canChange = Math.min(totalInRange - already, numOperations);
            res = Math.max(res, already + canChange);
        }
        return res;
    }
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations)
            x += (op.charAt(1) == '+') ? 1 : -1;
        return x;
    }
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String res = s;
        queue.offer(s);
        seen.add(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(res) < 0)
                res = cur;
            String added = add(cur, a);
            if (seen.add(added))
                queue.offer(added);
            String rotated = rotate(cur, b);
            if (seen.add(rotated))
                queue.offer(rotated);
        }
        return res;
    }

    private String add(String s, int a) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i += 2)
            ch[i] = (char) ((ch[i] - '0' + a) % 10 + '0');
        return new String(ch);
    }

    private String rotate(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long last = Long.MIN_VALUE;

        for (int num : nums) {
            long candidate = Math.max(last + 1, (long) num - k);
            if (candidate <= (long) num + k) {
                count++;
                last = candidate;
            }
        }
        return count;
    }
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            freq[mod]++;
        }
        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (freq[mod] == 0)
                break;
            freq[mod]--;
            mex++;
        }
        return mex;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), ans = 0, inc = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc++;
            else
                inc = 1;
            ans = Math.max(ans, inc / 2);
        }
        int len = 1;
        List<Integer> runs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                len++;
            else {
                runs.add(len);
                len = 1;
            }
        }
        runs.add(len);
        for (int i = 0; i + 1 < runs.size(); i++) {
            ans = Math.max(ans, Math.min(runs.get(i), runs.get(i + 1)));
        }
        return ans;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k))
                return true;
        }
        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1))
                return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }
        return result;
    }
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> sum = new HashMap<>();
        for (int p : power)
            sum.put(p, sum.getOrDefault(p, 0L) + p);
        List<Integer> vals = new ArrayList<>(sum.keySet());
        Collections.sort(vals);
        int n = vals.size();
        long[] dp = new long[n];
        dp[0] = sum.get(vals.get(0));
        for (int i = 1; i < n; i++) {
            long take = sum.get(vals.get(i));
            int j = i - 1;
            while (j >= 0 && vals.get(i) - vals.get(j) <= 2)
                j--;
            if (j >= 0)
                take += dp[j];
            dp[i] = Math.max(dp[i - 1], take);
        }
        return dp[n - 1];
    }
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n)
                dp[i] = energy[i] + dp[i + k];
            else
                dp[i] = energy[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long sumSkill = 0;
        for (int s : skill) {
            sumSkill += s;
        }
        long prevWizardDone = sumSkill * mana[0];
        for (int j = 1; j < m; ++j) {
            long prevPotionDone = prevWizardDone;
            for (int i = n - 2; i >= 0; --i) {
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                prevWizardDone = Math.max(prevPotionDone, prevWizardDone - (long) skill[i] * mana[j]);
            }
            prevWizardDone += sumSkill * mana[j];
        }
        return prevWizardDone;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long required = (success + spell - 1) / spell;
            int idx = lowerBound(potions, required);
            res[i] = m - idx;
        }
        return res;
    }
    private int lowerBound(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;
                if (fullLakes.containsKey(lake)) {
                    int lastRainDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
            }
        }
        return ans;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        pq.offer(new Cell(0, 0, grid[0][0]));
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int res = 0;
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            res = Math.max(res, curr.height);
            if (curr.row == n - 1 && curr.col == n - 1) {
                return res;
            }
            if (visited[curr.row][curr.col])
                continue;
            visited[curr.row][curr.col] = true;
            for (int[] dir : directions) {
                int nr = curr.row + dir[0];
                int nc = curr.col + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new Cell(nr, nc, grid[nr][nc]));
                }
            }
        }
        return -1;
    }
    private static class Cell {
        int row, col, height;

        Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n)
            return;
        if (visited[r][c])
            return;
        if (heights[r][c] < prevHeight)
            return;
        visited[r][c] = true;
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
    private static class Cell1 {
        int row, col, height;
        Cell1(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int water = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] d : directions) {
                int nr = cell.row + d[0];
                int nc = cell.col + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int neighborHeight = heightMap[nr][nc];
                    if (cell.height > neighborHeight) {
                        water += cell.height - neighborHeight;
                    }
                    pq.offer(new Cell(nr, nc, Math.max(neighborHeight, cell.height)));
                }
            }
        }
        return water;
    }
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            empty -= numExchange;
            numExchange++;
            drank++;
            empty++;
        }
        return drank;
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            drank += newFull;
            empty = empty % numExchange + newFull;
        }
        return drank;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = Math.abs(
                            points[i][0] * (points[j][1] - points[k][1]) +
                                    points[j][0] * (points[k][1] - points[i][1]) +
                                    points[k][0] * (points[i][1] - points[j][1]))
                            / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        long remainder = num % den;

        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int start = map.get(remainder);
                sb.insert(start, "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            int f = freq.getOrDefault(num, 0) + 1;
            freq.put(num, f);
            maxFreq = Math.max(maxFreq, f);
        }
        int total = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                total += f;
            }
        }
        return total;
    }
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<String>> cuisineToFoods;

    public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        Comparator<String> comp = (a, b) -> {
            int r1 = foodToRating.get(a);
            int r2 = foodToRating.get(b);
            if (r1 != r2) {
                return r2 - r1;
            }
            return a.compareTo(b);
        };

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(comp));
            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> foodsSet = cuisineToFoods.get(cuisine);

        foodsSet.remove(food);

        foodToRating.put(food, newRating);

        foodsSet.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }


    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            int curr = num;
            while (!stack.isEmpty()) {
                int last = stack.get(stack.size() - 1);
                int g = gcd(last, curr);
                if (g > 1) {
                    stack.remove(stack.size() - 1);
                    curr = lcm(last, curr);
                } else {
                    break;
                }
            }
            stack.add(curr);
        }
        return stack;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    private static int lcm(int a, int b) {
        return (int)((long)a / gcd(a, b) * b);
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if (canType)
                count++;
        }
        return count;
    }
    public static  String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelInsensitive.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower);
                } else {
                    String devoweled = devowel(lower);
                    if (vowelInsensitive.containsKey(devoweled)) {
                        result[i] = vowelInsensitive.get(devoweled);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }

        return result;
    }

    private static String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxVowel = 0;
        int maxConsonant = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (isVowel(c)) {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }
        return maxVowel + maxConsonant;
    }

//    private boolean isVowel(char c) {
//        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
//    }
    public static boolean doesAliceWin(String s) {
        int vowels = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels++;
        }
        return vowels > 0;
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> extracted = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                extracted.add(ch);
            }
        }
        Collections.sort(extracted);
        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                result.append(extracted.get(idx++));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> langSets = new ArrayList<>();
        for (int[] langs : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : langs)
                set.add(l);
            langSets.add(set);
        }
        Set<Integer> problematic = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            if (!canCommunicate(langSets.get(u), langSets.get(v))) {
                problematic.add(u);
                problematic.add(v);
            }
        }
        if (problematic.isEmpty())
            return 0;
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int knows = 0;
            for (int user : problematic) {
                if (langSets.get(user).contains(lang)) {
                    knows++;
                }
            }
            minTeach = Math.min(minTeach, problematic.size() - knows);
        }
        return minTeach;
    }

    private static boolean canCommunicate(Set<Integer> a, Set<Integer> b) {
        for (int lang : a) {
            if (b.contains(lang))
                return true;
        }
        return false;
    }
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long sharing = 0;
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = sharing;
        }
        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }
        return (int) result;
    }
    public static int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (isValid(a) && isValid(b)) {
                return new int[] { a, b };
            }
        }
        return new int[0];
    }
    private static boolean isValid(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
//        int[] arr = new int[2];
//        if(n>10){
//            for(int i =0 ; i<1; i++){
//                arr[i]=9;
//                i++;
//                arr[i]= n-9;
//            }
//
//        }
//        Arrays.sort(arr);
//        return arr;

    public static long minOperations(int[][] queries) {
        long result = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long totalSteps = stepsInRange(r) - stepsInRange(l - 1);
            result += (totalSteps + 1) / 2;
        }
        return result;
    }

    private static long stepsInRange(long x) {
        if (x <= 0)
            return 0;
        long sum = 0;
        long start = 1;
        int step = 1;

        while (start <= x) {
            long end = start * 4 - 1;
            if (end > x)
                end = x;
            sum += (end - start + 1) * (long) step;
            start *= 4;
            step++;
        }
        return sum;
    }
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }
        if (n % 2 == 1) {
            result[index] = 0;
        }
        return result;
    }
    public static int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) k * num2;
            if (val < k)
                continue;
            int bits = Long.bitCount(val);
            if (bits <= k && k <= val) {
                return k;
            }
        }
        return -1;
    }
    public static int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);
        if (dist1 == dist2) {
            return 0;
        } else if (dist1 < dist2) {
            return 1;
        } else {
            return 2;
        }
    }
    public static int numberOfPairs1(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ax = points[i][0], ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0], by = points[j][1];
                if (ax <= bx && ay >= by) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int cx = points[k][0], cy = points[k][1];
                        if (cx >= ax && cx <= bx && cy <= ay && cy >= by) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) count++;
                }
            }
        }
        return count;
    }
    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ax = points[i][0], ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0], by = points[j][1];
                if (ax <= bx && ay >= by) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int cx = points[k][0], cy = points[k][1];
                        if (cx >= ax && cx <= bx && cy >= by && cy <= ay) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) count++;
                }
            }
        }
        return count;
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0])
        );
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double delta = gain(pass, total);
            pq.offer(new double[]{delta, pass, total});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            double delta = gain(pass, total);
            pq.offer(new double[]{delta, pass, total});
        }
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }
        return sum / classes.length;
    }
    private static double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        for (int n : nums3) set3.add(n);
        for (int n : set1) hashTable.put(n, hashTable.getOrDefault(n, 0) + 1);
        for (int n : set2) hashTable.put(n, hashTable.getOrDefault(n, 0) + 1);
        for (int n : set3) hashTable.put(n, hashTable.getOrDefault(n, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }
        return result;
//        List<Integer> list = new ArrayList<>();
//        int num1 = nums1.length;
//        int num2 = nums2.length;
//        int num3 = nums3.length;
//        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
//        for (int num : nums1) {
//            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
//        }
//        for (int num : nums2) {
//            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
//        }
//        for (int num : nums3) {
//            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
//        }
//        for (Integer key : hashTable.keySet()) {
//            if (hashTable.get(key) >= 2) {
//                list.add(key);
//            }
//        }
//
////        HashSet<Integer> set = new HashSet<>();
////        for(int n1 : nums1){
////            set.add(n1);
////        }
////        for(int n2 : nums2){
////            set.add(n2);
////        }
////        for(int n3 : nums3){
////            set.add(n3);
////        }
////        for(int i =0; i<set.size(); i++){
////            list.add(i);
////        }
//
//
//        // if(num1 >= num2 || num1>=num3){
//        //    for(int i =0; i<num1 ; i++){
//        //     for(int j = 0; j<num2; j++){
//        //         if()
//        //     }
//        //    }
//        // }
//        return list;
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false;
        }
        return true;
    }
    public static int repeatedNTimes(int[] nums) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int num : nums) {
            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
            if (hashTable.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }
    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for (int j : candyType) {
            set.add(j);
        }
        int siz = n/2;
        for(int i =0; i<n; i++){
            if(siz<set.size()){
                return siz;
            }
        }
        return set.size();
    }
    public static long flowerGame(int n, int m) {
        long oddN = (n + 1) / 2;
        long evenN = n / 2;
        long oddM = (m + 1) / 2;
        long evenM = m / 2;

        return oddN * evenM + evenN * oddM;
    }
    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int r = 0; r < n; r++) {
            Set<Character> seen = new HashSet<>();
            for (int c = 0; c < n; c++) {
                char val = board[r][c];
                if (val != '.') {
                    if (seen.contains(val)) return false;
                    seen.add(val);
                }
            }
        }
        for (int c = 0; c < n; c++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < n; r++) {
                char val = board[r][c];
                if (val != '.') {
                    if (seen.contains(val)) return false;
                    seen.add(val);
                }
            }
        }
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> seen = new HashSet<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char val = board[boxRow + r][boxCol + c];
                        if (val != '.') {
                            if (seen.contains(val)) return false;
                            seen.add(val);
                        }
                    }
                }
            }
        }
        return true;
    }
    public static int totalFruit(int[] fruits) {
        Arrays.sort(fruits);
        int max = fruits[0];
        int count =0;
        int add =1;
        for(int i =0; i<fruits.length; i++){
            if(fruits[i]==max && add <=2){
//                add
                count++;
            }
            else {
                add++;
                count++;
            }
        }

//
//        HashSet<Integer> set = new HashSet<>();
//        int count =0;
//        for(int i = 0; i<fruits.length; i++){
//            set.add(fruits[i]);
//        }
//
//        for(int i = set.size(); i>0;i--){
//            System.out.println(set.contains(i));
//        }
        return count;
    }
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0.0;
        int maxArea = 0;
        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];
            double diagonal = Math.sqrt(l * l + w * w);
            int area = l * w;
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            }
            else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
    public static int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
    public static int countCharacters(String[] words, String chars) { // not completed
        int count = 0;
        char[] cha = chars.toCharArray();
        int t =0;
        for (String word : words) {
            while(t<words.length){
                char[] ss = word.toCharArray();
                for (int i = 0; i < cha.length; i++) {
                    for (int j = 0; j < ss.length; j++) {
                        if (ss[j] == cha[i]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    t++;
                }
            }
        }
        return count;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < ran.length; i++) {
            boolean found = false;
            for (int j = 0; j < mag.length; j++) {
                if (ran[i] == mag[j]) {
                    mag[j] = '#';
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    public static int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        return height * width;
    }
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[i][j] = (i == 0) ? 1 : height[i-1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] > 0) {
                    int minHeight = height[i][j];
                    for (int k = j; k >= 0; k--) {
                        if (height[i][k] == 0){
                            break;
                        }
                        minHeight = Math.min(minHeight, height[i][k]);
                        total += minHeight;
                    }
                }
            }
        }
        return total;
    }
    public boolean checkValid(int[][] matrix) {
        int m = matrix.length;
        for(int i =0; i<m;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j =0; j <m ; j++){
                hs.add(matrix[i][j]);
            }
            if(hs.size()!=m){
                return false;
            }
        }
        for(int i =0; i<m; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j =0; j<m; j++){
                hs.add(matrix[j][i]);
            }
            if(hs.size()!=m){
                return false;
            }
        }
        return true;
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i<m;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static int findContentChildren(int[] g, int[] s) {
    int count=0; int i=0; int j=0;
    Arrays.sort(g);
    Arrays.sort(s);
    while(i<g.length && j<s.length){
        if(g[i]<=s[j]){
            count++;
            i++;
        }
        else {
            j++;
        }
     }
    return count;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int n = 1;
        int[] uniqueArr = new int[set.size()];
        int i = 0;
        for (int num : set) {
            uniqueArr[i++] = num;
        }
        int j =0;
        while(n<=set.size()){
            if(uniqueArr[j]!=n){
                list.add(n);
                j++;
                n++;
            }
        }
        return list;
    }
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for (char ch : s.toCharArray()) {
            c ^= ch;
        }
        for (char ch : t.toCharArray()) {
            c ^= ch;
        }
        return c;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();

        return Collections.singletonList(list);
    }


    public static int maximum69Number (int num) {
        char[] digit = String.valueOf(num).toCharArray();
        for (int i = 0; i < digit.length; i++) {
            if (digit[i] == '6') {
                digit[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digit));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(i ==0 || j==2 && i==1){
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length;
        int n =matrix[0].length;
        for(int i = 0; i<m ;i++ ){
            for(int j =0; j<n; j++){
                if(matrix[i][j]== target){
                    return true;
                }
            }
        }
       return false;
    }
    public static String largestGoodInteger(String num) {
        String sample = "";
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                sample = sample.compareTo(num.substring(i, i+3)) > 0 ? sample : num.substring(i, i+3);
            }
        }
        return sample;
    }
    public static String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] words = s.split(" ");
        for (String word : words) {
         String ss =   fun(word);
         list.add(ss);
        }
        String result = String.join(", ", list);
        return result;
    }

    private static String fun(String word) {
      char[] arr = word.toCharArray();
      int s= 0; int e = word.length()-1;
      while(s<e){
          char t = arr[s];
          arr[s] = arr[e];
          arr[e] = t;
          s++;
          e--;
      }
        String str = String.valueOf(arr);
      return str;
    }

    public static int numJewelsInStones(String jewels, String stones) {
      int count =0;
      for(int i =0; i<jewels.length(); i++){
          for(int j =0; j<stones.length(); j++){
              if(jewels.charAt(i)==stones.charAt(j)){
                  count++;
              }
          }
      }
        return count;
    }
    public static int firstUniqChar(String s) {
     for(int i =0; i<s.length(); i++){
         boolean isUn = true;
         for(int j =0 ; j<s.length(); j++){
             if(i!=j&& s.charAt(i)== s.charAt(j)){
                 isUn = false;
                 break;
             }
         }
         if(isUn){
             return i;
         }
     }
     return -1;
    }
    public static boolean wordPattern(String pattern, String s) {
        int i =0;
        int n =pattern.length();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        List<String> list = new ArrayList<>();
        for (String word : words){
            list.add(word);
        }
        while(i <n){
            if(pattern.charAt(i) == 'a'){
                if(Objects.equals(list.get(i), "dog") || Objects.equals(list.get(i), "a") || Objects.equals(list.get(i), "b") ){
                    i++;
                }
                else{
                    return false;
                }
            }
            else if (pattern.charAt(i) == 'c'){
                if(Objects.equals(list.get(i), "a") || Objects.equals(list.get(i), "dog")){
                    i++;
                }
            }
            else {
                if(Objects.equals(list.get(i), "cat") || Objects.equals(list.get(i),"b") || Objects.equals(list.get(i), "c")){
                    i++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
//    public static boolean isValid(String s) {
//     List<String> list = new ArrayList<>(0);
////     int i =0;
//     for(int i =0; i<s.length(); i++){
//         list.add(String.valueOf(i));
//     }
//     int i =1;
//     if(s.charAt(i)list.get(i))
//     return true;
//    }
    public static  int numMatchingSubseq(String s, String[] words) {
        int count =0;
        for (String word : words) {
            int i =0;
            int j =0;
            for (char letter : word.toCharArray()) {
                while(j< words.length){
                    if(s.charAt(i) == word.charAt(j)){
//                        j++;
                    }
                }

                System.out.println(letter);
            }
        }

        return count;
    }
    public static boolean isSubsequence(String s, String t) {
        int count =0;
        int n = s.length();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                count++;
            }
            j++;
        }
       if(count==s.length()){
        return true;
       }
        return false;
    }
    public static int singleNumber(int[] nums) {
        int count =0;
        for(int i =0; i<nums.length; i++){
            int num = nums[i];
            for(int j =0; j<nums.length ; j++){
                if(num == nums[j]){
                    count++;
                }
            }
            if(count ==1){
                return num;
            }
            else{
                count =0;
            }
        }
        return 0;
    }
    public static String[] findRelativeRanks(int[] score) {
        ArrayList<String> list = new ArrayList<>();
        int [] copy = score.clone();
        if(score.length==1){
            list.add("Gold Medal");
        }
        else {
            Arrays.sort(score);
            int gm = score[score.length-1];
            int sm = score[score.length-2];
            int bm = score[score.length-3];
            for(int i = 0; i<score.length; i++){
                if(score[i] == gm){
                    list.add("Gold Medal");
                }
                else if(score[i] ==sm){
                    list.add("Silver Medal");
                }
                else if(score[i] ==bm){
                    list.add("Bronze Medal");
                }
            }
            System.out.println(list);
            int i =0;
            for(String ss : list){
                if(gm == copy[i]){
                    copy[i] = Integer.parseInt(list.get(2));
                }
                else if (sm == copy[i]){
                    copy[i] = Integer.parseInt(list.get(1));
                } else if (bm == copy[i]) {
                    copy[i] = Integer.parseInt(list.get(0));
                }
            }
//            for(int i =0; i<copy.length;i++){
//                if(gm == copy[i]){
//                    copy[i] = Integer.parseInt(list.get(2));
//                }
//                else if (sm == copy[i]){
//                    copy[i] = Integer.parseInt(list.get(1));
//                } else if (bm == copy[i]) {
//                    copy[i] = Integer.parseInt(list.get(0));
//                }
//            }
        }

        String[] s = new String[copy.length];
        for(int i =0; i<copy.length; i++){
            s[i] = String.valueOf(copy[i]);
        }
        return s;
    }
    public static void duplicateZeros(int[] arr) {
        int s = 0;
        List<Integer> list = new ArrayList<>();
        while(s< arr.length){
            if(arr[s]==0){
                list.add(arr[s]);
                list.add(0);
                s++;
            }
            else {
                list.add(arr[s]);
                s++;
            }
        }
       for(int i =0; i<=arr.length-1; i++){
           arr[i] = list.get(i);
       }
        System.out.println(Arrays.toString(arr));
    }
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
      ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
      int i =0;
      int j = 0;
      int temp =-1;

      while (i<a.length && j<b.length){
          if(a[i]<=b[j] && a[i]>temp){
              list.add(a[i]);
              temp = a[i];
              i++;
          }
          else if(b[j]>temp) {
              list.add(b[j]);
              temp = b[j];
              j++;
          }
          else {
              if (a[i] > temp) {
                  list.add(a[i]);
                  temp = a[i];
              }
              i++;
              j++;
          }
      }
        while (i < a.length) {
            if (a[i] > temp) {
                list.add(a[i]);
                temp = a[i];
            }
            i++;
        }

        // Add remaining elements from b
        while (j < b.length) {
            if (b[j] > temp) {
                list.add(b[j]);
                temp = b[j];
            }
            j++;
        }

       return list;
    }
    public static int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> union = new HashSet<>();
        for(int i = 0; i<nums1.length ; i++){
            union.add(nums1[i]);
        }
        for(int i =0; i<nums2.length ; i++){
            union.add(nums2[i]);
        }
        int[] u = new int[union.size()];
        int i = 0;
        for (int num : union) {
            u[i++] = num;
        }
        return u;
    }
    public static void moveZeroes(int[] nums) {
        int j = -1;
        for(int i = 0; i<nums.length ;i++){
            if(nums[i]==0){
                j= i;
                break;
            }
        }
        for(int i = j+1; i<nums.length; i++){
            if(nums[i]!=0){
                //swap(nums[i], nums[j]);
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
                j++;
            }
        }
//       List<Integer> temp = new ArrayList<>();
//       for(int i =0; i< nums.length ; i++){
//           if(nums[i]!=0){
//               temp.add(nums[i]);
//           }
//       }
//       int nonZeros = temp.size();
//       for(int i =0; i< temp.size();i++){
//           nums[i] = temp.get(i);
//       }
//       for(int i = nonZeros; i<nums.length; i++){
//           nums[i] =0;
//       }
        System.out.println(Arrays.toString(nums));
    }
    public static void moveAllZerosToLast(int[] arr){
        int n = arr.length-1;
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i<=n; i++){
            if(arr[i]!=0){
           temp.add(arr[i]);
            }
        }
        for(int i = 0; i<temp.size();i++){
            arr[i] = temp.get(i);
        }
       int noOfZeros = temp.size();
        for(int i =noOfZeros;i<=n;i++){
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int[] optimalSolutinZerosToLast(int[]arr){
        int j = -1;
        int n = arr.length;
        for(int i= 0 ; i<n; i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            return arr;
        }
        for(int i = j+1; i<n; i++){
            if(arr[i]!=0){
                swap(arr[i],arr[j]);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static void swap(int i, int j) {
        int temp = i;
        i=j;
        j=temp;
    }
}
