package com.zoho.problems;
import java.sql.SQLOutput;
import java.util.Arrays;


public class Sort_OddEven {
    public static void sortOddEven(int[] arr){
        Arrays.sort(arr);

        int n = arr.length;
        int[] temp = new int[n];
        int idx = 0;

        // Add all odd numbers first (from the end for descending order)
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                temp[idx++] = arr[i];
            }
        }

        // Then add all even numbers (from start for ascending order)
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                temp[idx++] = arr[i];
            }
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
