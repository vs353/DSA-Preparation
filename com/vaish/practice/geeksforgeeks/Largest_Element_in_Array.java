package com.vaish.practice.geeksforgeeks;

public class Largest_Element_in_Array {
    public static int largest(int[] arr) {
    int largest = arr[0];
        for (int i : arr) {
            if (largest < i) {
                largest = i;
            }
        }
    return largest;
    }
}
