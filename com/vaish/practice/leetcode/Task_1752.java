package com.vaish.practice.leetcode;

public class Task_1752 {
    public static boolean check(int[] nums) {
        int pivot = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if ( nums[i] > nums[i + 1] ) {
                return false;
            }
        }
        return true;
    }
}
