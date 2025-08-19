package com.strivers.arrays.easy;

import java.util.*;

public class ZerosLast {
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
