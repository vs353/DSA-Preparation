package com.vaish.practice.leetcode.hashing;

import java.util.ArrayList;
import java.util.List;

public class FirstUniqueChar_387 {
    public static int firstUniqChar(String s) {
        int index = 0;
        List<Integer> ans = new ArrayList<>();
   //     int[] map = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            char t = s.charAt(0);
            if(t != s.charAt(i)){
                return i;
            }
          //  map[s[i]] ++;
        }

        return -1;
    }
}
