package com.vaish.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_11 {
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