package com.vaish.practice.leetcode;

public class Task_28 {
    public int strStr(String haystack, String needle) {
        char ls2 = 0;
        int index = 0;
        for(int i = 0 ; i<haystack.length(); i++){
            char ch1 = haystack.charAt(i);
            for(int j = 0; j<needle.length() ; j++){
                char ch2 = needle.charAt(j);
                if(ch1 ==ch2){
                    index = i;
                    i++;
                    j++;
                    if(j == needle.length()-1){
                        return  index;
                    }
                }
                else if (ch1!= ch2){
                    index = 0;
                    i++;
                    j=0;
                }
            }

        }
        return -1;

    }
}
