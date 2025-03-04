package com.vaish.practice;

import java.math.BigDecimal;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        BigDecimal x = BigDecimal.valueOf(0);
        for(int i = 0; i< digits.length; i++){
            x = (x.multiply(BigDecimal.valueOf(10))).add(BigDecimal.valueOf(digits[i]));

        }
        x = x.add(BigDecimal.valueOf(1));
       int c =  count(x);
        int[] n = new int [c];
//        int s = n[0];
//        int e = n.length;
        for(int i = c-1; i>=0 ; i--){
            n[i] =(x.remainder(BigDecimal.valueOf(10))).intValue();
            x = x.divide(new BigDecimal(10));
        }

        return n;
    }

    private static int count(BigDecimal x) {
        int count = 0;
        while(x.compareTo(new BigDecimal(0))>0){
            x = x.divide(BigDecimal.valueOf(10));
            count++;
        }
        return count;
    }
}
