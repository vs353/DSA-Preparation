package com.vaish.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Task_20 {
    public static boolean isValid(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
//        List<String> str;
        if(len%2!=0){
            return false;
        }
        for(int i = 0; i<s.length(); i++){
           char ch = s.charAt(i);
           list.add(String.valueOf(ch));
        }
        int i = 0;
        int j = Integer.parseInt(list.get(i+1));
        while(i<list.size()){
            if(i==j){
                i++;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        String ss = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if(ss.isEmpty()){
            return true;
        }
        List<String> list = new ArrayList<>();
        for(int i = 0; i<ss.length(); i++){
            char ch = ss.charAt(i);
            list.add(String.valueOf(ch));
        }
        int start = 0;
        int end = list.size()-1;
        while(start<=end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
