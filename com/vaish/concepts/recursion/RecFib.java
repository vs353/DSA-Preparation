package com.vaish.concepts.recursion;

public class RecFib {
    public static int recFibonacci(int n){
    if(n<=1){
        return n;
    }
    return recFibonacci(n-1)+recFibonacci(n-2);
    }
}
