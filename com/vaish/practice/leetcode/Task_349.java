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
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int [] result = new int[list.size()];
        for(int i = 0; i< list.size() ;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
