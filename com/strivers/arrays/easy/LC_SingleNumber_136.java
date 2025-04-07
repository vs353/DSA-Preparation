package com.strivers.arrays.easy;

import java.util.Arrays;

public class LC_SingleNumber_136 {
    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
        int xor = 0;
        for(int i = 0; i<nums.length; i++){
            xor = xor^nums[i];
        }

//                int temp = 0;
//    for(int i = 0; i<nums.length; i++){
//        if(nums.length==1){
//            return nums[i];
//        }
//        temp = temp+ nums[i]^nums[i+1];
//        if(temp!=0){
//          return i;
//        }
//    }
//    return 2;
        return xor;
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;
        for( int j = 1 ; j< nums.length ; j++){
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
