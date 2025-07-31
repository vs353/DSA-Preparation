package com.vaish.practice.leetcode;

import com.vaish.concepts.arrays.Arrays;

public class Task_263 {
    public static String longestCommonPrefix(String[] strs) {
        for(String st : strs){
        for(int i = 0; i<st.length(); i++){
            char ch = st.charAt(i);

            }
        }

    return"";
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false;

        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public  static int searchInsert(int[] nums, int target) {
        int a = 0;
        for(int i = 0; i<nums.length; i++){
            int last = nums.length-1;
//            System.out.println(last);
            if (nums[last] < target){
                return last+1;
            }
            if(nums[i]<=target){
                if(nums[i]== target){
                    return i;
                }
            }
            if(nums[i]>target){
                a = i;
                break;
            }

//            else{
//                a = i+1;
//            }
        }
        return a;
    }

}
