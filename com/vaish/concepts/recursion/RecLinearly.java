package com.vaish.concepts.recursion;

public class RecLinearly {
    public static void print1ToN(int i , int n){
     if(i> n){
         return;
     }
     System.out.println(i);
     print1ToN(i+1, n);
    }

    public static void reverseNTo1(int i , int n){
        if(i<1)
        {
            return;
        }
        System.out.println(i);
        reverseNTo1(i-1, n);
    }

}
