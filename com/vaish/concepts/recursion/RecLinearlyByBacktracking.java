package com.vaish.concepts.recursion;

public class RecLinearlyByBacktracking {
    public static void linearlyByBacktracking(int i , int n){
        int sum =0;
        if(i<1){
            return;
        }
        System.out.println(i);
        linearlyByBacktracking(i -1 , n);
        System.out.println(i);
    }
   /* public static void reverseLinearlyByBT(int i , int n){
        if(i>n){
            return;
        }
        reverseLinearlyByBT(i+1, n);
        System.out.println(i);
    }*/
}
