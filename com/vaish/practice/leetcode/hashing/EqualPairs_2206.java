package com.vaish.practice.leetcode.hashing;

import java.util.ArrayList;
import java.util.List;

public class EqualPairs_2206 {
    public static boolean divideArray(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[5000];
        for(int i=0;i<nums.length;i++){
            map[nums[i]%10] ++;
        }
        for(int i=1;i<nums.length+1;i++){
            ans.add(map[i]);
        }
        boolean f = countEqualPairs(map);
        return f;
    }

    private static boolean  countEqualPairs(int[] map) {
        int[] fin = map;
        int i = 0;
        while(i<= fin.length -1){
            if(fin[i] %2 != 0){
                return false;
            }
            i++;
        }
        return true;
    }

}
