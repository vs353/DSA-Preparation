package com.strivers.arrays.easy;

import java.util.Arrays;

public class LC_MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int t = nums[0];
        int e = nums.length;
        if(nums.length==1){
            if(nums[0]==1){
                return 0;
            }
            return 1;
        }
        for(int i = 0; i<e; i++){
            if(nums[0]>=1){
                return 0;
            }
            if(t != nums[i]){
                return i;
            }
            t++;
        }
        return e;
    }
}
