package com.strivers.arrays.easy;

import java.util.Arrays;

public class LeftRotate {
    public static void left_Rotate(int [] arr){
        int n = arr.length;
        int temp = arr[0];
        for(int i = 1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        System.out.println(Arrays.toString(arr));
    }

    public static void right_Rotate(int[] arr) {
        int n = arr.length;
        int temp = arr[n-1];
        for(int i = arr.length-2; i>=0 ; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
