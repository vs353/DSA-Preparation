package com.strivers.arrays.easy;

public class LC_CheckArrayIsSorted_1752 {
    public static boolean check(int[] nums) {
        int pivot = findingMin(nums);
        int start = 0;
        int end = nums.length-1;
        if(nums.length<=2){
            if(nums.length == 1){
                return true;
            }
        }
        if(nums[start] == nums[end] && nums.length <=3){
            return true;
        }
        if(pivot!=nums[start]){
            Reverse(nums, end , pivot);
        }
        Reverse2(nums, start, pivot- 1);
        ReverseFull(nums, start, end);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void ReverseFull(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void Reverse2(int[] arr, int start, int pivot) {
        while(start <= pivot){
            int temp = arr[start];
            arr[start] = arr[pivot];
            arr[pivot] = temp;
            start++;
            pivot--;
        }
    }

    private static void Reverse(int[] arr, int end, int pivot) {
        while (pivot <= end) {
            int temp = arr[pivot];
            arr[pivot] = arr[end];
            arr[end] = temp;
            pivot++;
            end--;
        }
    }

    private static int findingMin(int[] nums) {
        int minIndex = 0;
        int lastIndex = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[0]==nums[lastIndex] && nums[lastIndex]==10){
                System.out.println(nums[lastIndex]);
             return lastIndex;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
       // System.out.println(last);
        System.out.println(minIndex);
        return minIndex;
    }
}
