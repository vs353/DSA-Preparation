package com.zoho.problems;

import java.util.HashSet;

public class Remove_Duplicates {
    public static void RemoveDuplicates(int[] nums){
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for(int num : nums){
//            if( uniqueNumbers.add(num)){
//                System.out.print(num + " ");
//            }
        uniqueNumbers.add(num);
        }
        System.out.println(uniqueNumbers);
    }
}
