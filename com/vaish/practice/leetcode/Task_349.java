package com.vaish.practice.leetcode;

import com.zoho.problems.Remove_Duplicates;

import java.util.*;

public class Task_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
     Set<Integer>  set = new HashSet<>();
     Set<Integer> setResult = new HashSet<>();

     for(int num : nums1){
         set.add(num);
     }
     for(int num : nums2){
      if(set.contains(num)){
          setResult.add(num);
      }
     }
        int[] result = new int[setResult.size()];
        int i = 0;
        for(int num: setResult){
            result[i++] = num;
        }
        return result;
    }

    public static  int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer>  result = new HashSet<>();
        if(nums1.length> nums2.length) {
            for (int num : nums1) {
                set.add(num);
            }
            for (int num : nums2) {
                if (set.contains(num)) {
                    result.add(num);
                }
            }
        }
        else {
            for (int num : nums2) {
                set.add(num);
            }
            for (int num : nums1) {
                if (set.contains(num)) {
                    result.add(num);
                }
            }
        }

        int[] arr = new int[result.size()];
        int i=0;
        for(int num : result){
            arr[i++] = num;
        }
        return arr;
    }


}
