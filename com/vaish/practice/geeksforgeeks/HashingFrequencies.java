package com.vaish.practice.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class HashingFrequencies {

    public static List<Integer> frequencyCount(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            map[arr[i]] ++;
        }

        for(int i=1;i<arr.length+1;i++){
            ans.add(map[i]);
        }
        System.out.println(ans);
        return ans;
    }
}
