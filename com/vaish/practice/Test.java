package com.vaish.practice;

import static java.lang.Math.min;

public class Test {
    //  two numbers 12 , 16
    // 2l, 4g
    public static int testGCD(int a, int b){
       // int max=0;
        int i = min(a,b);
        while (i>=1) {
            if(a%i ==0 && b % i ==0) return i;
            i--;
        }
        return 1;
    }
}
