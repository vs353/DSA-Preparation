package com.vaish.practice.leetcode;

import java.util.Locale;

public class Task_2129 {
    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");
//        StringBuilder sb = new StringBuilder();
        for(String word : words){
            for(int i = 0; i< word.length(); i++){
             if(word.length()<=3){
                 word.toLowerCase(Locale.getDefault());
//                 sb.append(word);
             }
             else if(word.length()>3){
                  String f = String.valueOf(word.charAt(0));
                  String.valueOf(f).toUpperCase(Locale.getDefault());

//                 String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
//                 sb.append(capitalized).append(" ");
             }
            }
            System.out.println(word);
        }

        return " ";
    }
}
