package com.vaish.practice;

public class IsPrime {
    public static boolean isPrimeNumber(int n){
        int count = 0;
        for(int i = 2 ; i*i<=n; i++){
           if(n%i ==0){
               count ++;
           }
        }
        return count == 1;
    }
}
