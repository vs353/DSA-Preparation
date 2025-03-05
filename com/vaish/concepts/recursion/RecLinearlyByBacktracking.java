package com.vaish.concepts.recursion;

public class RecLinearlyByBacktracking {
    public static void linearlyByBacktracking(int i , int n){
        if(i<1){
            return;
        }
        linearlyByBacktracking(i -1 , n);
        System.out.println(i);
    }
    public static void reverseLinearlyByBT(int i , int n){
        if(i>n){
            return;
        }
        reverseLinearlyByBT(i+1, n);
        System.out.println(i);
    }
}
