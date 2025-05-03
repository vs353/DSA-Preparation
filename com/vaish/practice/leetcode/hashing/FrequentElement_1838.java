package com.vaish.practice.leetcode.hashing;

import java.util.ArrayList;
import java.util.List;

public class FrequentElement_1838 {
    public static int maxFrequency(int[] nums, int k) {
        int max = findMax(nums);
        int ans = increament(max, nums, k);
        return ans;
    }

    private static int increament(int max, int[] nums, int k) {
        int count = 0;
        int i = 0;
//        for(int i = 0; i<=nums.length+1; i++){
//            if(nums[i]==max) {
//                count++;
//            }
            while(k>=0){
                if(nums[i]==max){
                    i++;
                    count++;

                }
                if(nums[i]<=max){
                    if(nums[i] != max) {
                        nums[i] = nums[i] + 1;
                    }
                    k--;
                }
            }
//        }
        return count;
    }
    public static int findMax(int[] nums){
        int max = nums[0];
        for(int i = 0; i<nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }
}
