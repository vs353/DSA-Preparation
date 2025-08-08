package com.strivers.arrays.easy;

import java.util.Arrays;

public class removeDuplicates {
    private static void reverse(int[] nums,int s, int e) {
//        if(s==e){
//        }
//        else {
            while(s<=e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
//        }
    }
    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;
        if(d !=0){
            if(nums.length%2!=0){
//                if(d==1){
//                    if(n>3){
//                        reverse(nums, 0, d);
//                    }
//                    reverse (nums, 0, n-1);
//                }
//                else{
                    reverse(nums, n-d, n-1);
//                    if(n>3){
                if(n-1!=d){
                    if(k>n){
                        reverse(nums, 0,n-(d+1));
                    }
                    else {
                        if(n-d > d){
                            reverse(nums, 0,n-(d+1));
                        }
                        else{
                            if(k==d){
                                reverse(nums,0,n-(d+1) );
                            }
                            else {
                                reverse(nums, 0, d);
                            }
                        }
                    }

                }
//                    }
                    reverse (nums, 0, n-1);
//                }
            }
            else {
                 n = n-1;
//                reverse(nums, d, n);
//                reverse(nums, 0, n-d);
//                reverse (nums, 0, n);
                reverse(nums, n-(d-1), n);
                if(n!=d){
                    reverse(nums, 0, n-d);
                }
                reverse (nums, 0, n);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length-1;
        int d = k%n;
        reverse(nums, 0,d-1);
        reverse(nums,d, n);
        reverse(nums,0,n);
        System.out.println(Arrays.toString(nums));
    }



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
