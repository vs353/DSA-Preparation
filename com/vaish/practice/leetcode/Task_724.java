package com.vaish.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public  static String[] findWords(String[] words) {
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for(String word : words){
            String lower = word.toLowerCase();
            if(inRow(lower , r1) || inRow(lower, r2) || inRow(lower, r3)){
                list.add(word);
            }
        }
        String[] ss = list.toArray(new String[0]);

        return ss;
    }
    private static  boolean inRow(String word , String row){
        for(char ch : word.toCharArray()){
            if(row.indexOf(ch) ==-1){
                return false;
            }
        }
        return true;
    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;
        int[] n1= Arrays.copyOf(nums, nums.length);
        Arrays.sort(n1);
        int min = n1[nums.length-2];
        System.out.println(min);
        for(int i =0; i<nums.length; i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        if(max>=2*min){
            return index;
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
