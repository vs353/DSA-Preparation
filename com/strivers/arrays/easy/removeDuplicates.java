package com.strivers.arrays.easy;

import java.util.Arrays;

public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
            int i =0;
            for(int j =1; j<nums.length; j++){
                if(nums[j]!=nums[i]){
                    nums[i+1] = nums[j];
                    i++;
                }
            }
        return i+1;
    }

    public static  void rotateArray(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;
        int[] temp = new int[d];
        for(int i = 0; i<d; i++){
            temp[i] = nums[i];
        }
        for(int i = d ; i<n ; i++ ){
            nums[i-d] = nums[i];
        }
        for(int i = n-d ; i<n; i++){
            nums[i] = temp[i-(n-d)];
        }
        System.out.println(Arrays.toString(nums));
    }
}
