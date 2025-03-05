package com.vaish.concepts.recursion;

public class RecParameter {
    public static void recParameter(int i , int sum){
    if(i <1){
    System.out.println(sum);
    return;
    }
    recParameter(i-1, sum+i);
    }

    public static int recFunctional(int n){
     if(n ==0){
         return 0;
     }
     return n+recFunctional(n-1);
    }

    public static int recFactorial(int n){
        if(n ==0){
            return 1;
        }
        return n * recFactorial(n-1);
    }

}
