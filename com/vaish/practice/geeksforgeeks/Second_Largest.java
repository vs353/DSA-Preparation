package com.vaish.practice.geeksforgeeks;

public class Second_Largest {
    public static int getSecondLargest(int[] arr) {
        int firstLargest = arr[0];
        int secondLargest = -1;
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
