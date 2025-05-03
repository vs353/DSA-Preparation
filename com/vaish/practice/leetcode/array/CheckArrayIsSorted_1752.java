package com.vaish.practice.leetcode.array;

public class CheckArrayIsSorted_1752 {
    public static boolean check(int[] nums) {
        int min = nums[0];
        int n = nums.length;
        int temp = nums[0];
        int pivot = findmin(min, nums);
        if(nums.length<=2){
            if(nums.length == 1){
                return true;
            }
            if(pivot<min){
                return true;
            }
        }
        for(int i =1 ; i<n; i++){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
       boolean ch =  checkSort(nums);

        return ch;
    }

    public static boolean checkSort(int[] nums) {
       for(int i = 0; i < nums.length ; i ++){
           if(nums[i] < nums[i +1] ){
            return true;
           }
           else if(nums[i] > nums[i+1]){
               return true;
           }

       }

        return false;
    }

    private static int findmin(int p , int[] nums) {
        for(int i = 0; i <nums.length; i++){
            if(p > nums[i]){
                p = nums[i];
            }
        }
        return p;
    }
}

//        for(int i = pivot ; i <nums.length ; i++){
//            if(pivot>nums[i]){
//                return false;
//            }
//        }
//        for(int j = min ; j<nums.length ; j++){
//            if(nums[pivot] == nums[min]){
//                return true;
//            }
//  if(pivot==min){
//     return true;
// }
//  if(pivot>nums[j]){
//     return false;
// }
//            if (nums[pivot-1]<nums[pivot+1]) {
//                return false;
//            }
//
//
//        }
//



//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i - 1]) {
//                return false;
//            }
//        }