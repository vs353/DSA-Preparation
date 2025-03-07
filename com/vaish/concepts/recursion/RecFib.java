package com.vaish.concepts.recursion;

public class RecFib {
    public static int recFibonacci(int n){
    int lastNum = 0;
    int secLastNum = 0;
    if(n<=1){
        return n;
    }
    lastNum = recFibonacci(n-1);
    secLastNum =recFibonacci(n-2);
    return lastNum+secLastNum;
    }
}
