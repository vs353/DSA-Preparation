package com.strivers.arrays.easy;

public class GFG_Largest_Element_in_Array {
    public static int largest(int[] arr) {
    int largest = arr[0];
        for (int i : arr) {
            if (largest < i) {
                largest = i;
            }
        }
    return largest;
    }

    public static class Second_Largest {
        public static int getSecondLargest(int[] arr) {
            int firstLargest = arr[0];
            int secondLargest = -1;
            if(arr.length<2){
                return -1;
            }
            for(int i : arr){
                if(firstLargest < i){
                    secondLargest = firstLargest;
                    firstLargest = i;
                } else if (i<firstLargest&& i >secondLargest) {
                    secondLargest = i;
                }
            }
            return secondLargest;
        }
    }
}
