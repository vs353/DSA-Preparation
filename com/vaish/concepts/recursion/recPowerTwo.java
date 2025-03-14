package com.vaish.concepts.recursion;

public class recPowerTwo {
    public static boolean isPowerTwo(int n, int x ) {
        if(x>n){
            return false;
       }
        if(x==n){
            return true;
        }
        x= x*2;
        return isPowerTwo(n, x);
    }
}
