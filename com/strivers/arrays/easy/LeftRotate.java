package com.strivers.arrays.easy;

import java.util.Arrays;

public class LeftRotate {
    public static void rotate(int[] nums, int k) {
        int end = nums.length;
        int start = nums[0];
        int pivot = k;
        reverse1(nums, start, pivot);
        reverse2(nums,pivot,end);
        reverse(nums, start,end);

    }

    private static void reverse(int[] arr, int start, int end) {
        while(start>=end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }

    private static void reverse2(int[] arr, int pivot, int end) {
        while(pivot<=end){
            int temp = arr[pivot+1];
            arr[pivot+1] = arr[end];
            arr[end] = temp ;
            pivot++;
            end--;
        }
        
    }

    private static void reverse1(int[] arr, int start, int pivot) {
        while(start>= pivot){
            int temp = arr[start];
            arr[start] = arr[pivot];
            arr[pivot] = temp;
            start++;
            pivot--;
        }
    }

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

    public static void left_Rotate_DPlace(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int  [d];
        for(int i =0; i<d; i++){
            temp[i] = arr[i];
        }
        for(int i = d ; i<arr.length; i++){
            arr[i-d] = arr[i];
        }
        for(int i = n-d; i<n;i++ ){
            arr[i] = temp[i-(n-d)];
        }
        System.out.println(Arrays.toString(arr));
    }
    
}
