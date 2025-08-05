package com.vaish.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_11 {

    public static int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(target == nums[i] ){
                list.add(i);
            }
        }
        if(list.isEmpty()){
            list.add(-1);
            list.add(-1);
        }
//        int i = 0;
//        if(list.size() ==1){
//            if(list.contains()){
//                list.add(list.get(i));
//            }
//            else if ( (list.contains(0))) {
//                list.add(0);
//            }

//        }
//        int[] arr = new int[2];
//        for(int j = 0; j< list.size(); j++){
//            if(list.size()>2){
//                int s = list.get(j);
//                int e = list.get(list.size()-1);
//                arr[j] = s;
//                arr[j] = e;
//            }
//            else {
//                arr[j] = list.get(j);
//            }
        int[] arr = new int[2];
        if (list.size() >= 2) {
            arr[0] = list.get(0);                  // first value
            arr[1] = list.get(list.size() - 1);    // last value
        } else if (list.size() == 1) {
            arr[0] = list.get(0);
            arr[1] = list.get(0); // or 0 or any default

        }
        return arr;
    }

    public static int maxArea(int[] height) {
        int range = 0;
        int s= 0;
        int e = height.length-1;
        int res =0;
        if(height.length<=2){
            if(height[s]==height[e]){
                range = height[s]*height[e];
                return range;
            }
            if(height[s]<height[e]){
                range = height[s]*height[s];
                return range;
            }
            else{
                range =height[e]*1;
                return range;
            }
        }
        if (height[s] == height[e] && height[s] < height[s + 1]) {
            range = (height[s] * height[e]) + 1;
            return range;
        }
        if(height[s]== height[e]){
            range = height[s]*height[e];
            return range;
        }
        List<Integer> list = new ArrayList<>();
        while(s<e){
            range = e-s;
            if(height[s]>height[e]){
                res = height[e]* range;
                list.add(res);
                s++;
            }
            if(height[s]<height[e]){
                res = height[s]*height[e];
                list.add(res);
                s++;
            }
        }
        int max = 0;
        for(int i =0; i<list.size();i++){
            if(max< list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }
}

/*___________________________
int left = 0, right = height.length - 1;
int maxArea = 0;
        while (left < right) {
int h = Math.min(height[left], height[right]);
int width = right - left;
int area = h * width;
maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
left++;
        } else {
right--;
        }
        }
        return maxArea;

 -----------------------------------*/