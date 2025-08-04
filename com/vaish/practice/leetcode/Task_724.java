package com.vaish.practice.leetcode;

import java.util.Arrays;

public class Task_724 {
    public static int pivotIndex(int[] num1) {
        int totalSum = 0;
        for (int num : num1) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < num1.length; i++) {
            int rightSum = totalSum - leftSum - num1[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += num1[i];
        }

        return -1;
    }

    public static int heightChecker(int[] heights) {
        int[] newList = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newList);
        int count =0;
        for(int i =0; i<heights.length; i++){
            if(heights[i] != newList[i]){
                count ++;
            }
        }
        return count;
    }
}
