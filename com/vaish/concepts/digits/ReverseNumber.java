package com.vaish.concepts.digits;

import static java.lang.Math.log10;

public class ReverseNumber{
    public static int reverseNumbers(int n){
        int rev = 0;
        int lastDigit=0;
        while(n >0){
            lastDigit = n %10;
            rev = (rev* 10) + lastDigit;
            n = n / 10;
        }
        return rev;
    }
    
}
