package com.vaish.practice.leetcode;

import java.util.Arrays;

public class Task_283 {
    public static void moveZeroes(int[] nums) {
        Arrays.sort(nums);
//        int n = nums.length;
//        int temp = nums[0];
//        for(int i = 1; i< n; i++){
//            if(nums[i]==0){
//                nums[i-1] = nums[i];
//            }
//            nums[n-1] = temp;
//        }

        System.out.println(Arrays.toString(nums));
    }
}
