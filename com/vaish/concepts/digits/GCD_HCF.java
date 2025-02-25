package com.vaish.concepts.digits;

import static java.lang.Math.min;

public class GCD_HCF {
    public static int isGCD_HCF(int a, int b){
        int gcd = 0;
/*
        for(int i =1; i<=min(a,b); i++){
            if(a%i ==0 && b %i==0){
                gcd= i;
            }
        }
       return  gcd;
*/
        /*
        for(int i = min(a,b); i>=1; i--){
            if(a%i ==0 && b %i==0){
                gcd = i;
                break;
            }
        }
        return gcd;
        */

        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }
            else {
                b=b%a;
            }
        }
        if(a==0 ){
            return b;
        }
        else {
            return a;
        }
    }
}
