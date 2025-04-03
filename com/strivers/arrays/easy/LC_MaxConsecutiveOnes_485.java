package com.strivers.arrays.easy;

import java.util.ArrayList;

public class LC_MaxConsecutiveOnes_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0 ){
                list.add(count);
                count=0;
            }
            else {
                count++;
            }
        }
        list.add(count);
        int ans = findCount(list);
     return ans;
    }

    private static int findCount(ArrayList<Integer> list) {
        int max= Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
