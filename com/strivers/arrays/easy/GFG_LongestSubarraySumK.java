package com.strivers.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class GFG_LongestSubarraySumK {
    public static int longestSubarray(int[] a, int k) {
     int n = a.length;
     Map<Long, Integer> perSumMap = new HashMap<>();
     long sum = 0;
     int maxLen = 0;
     for(int i = 0; i<n ;i++){
         sum+= a[i];

     if(sum == k) {
         maxLen =  Math.max(maxLen, i + 1);
     }
     long rem = sum -k;
     if(perSumMap.containsKey(rem)){
         int len = i- perSumMap.get(rem);
         maxLen = Math.max(maxLen, len);
     }
     if(!perSumMap.containsKey(sum)){
         perSumMap.put(sum,i);
     }
     }
     return maxLen;
    }
}
