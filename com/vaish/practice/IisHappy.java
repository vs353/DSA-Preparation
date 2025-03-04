package com.vaish.practice;

public class IisHappy {
    public static boolean isHappy(int n) {
        int val = n;
        if(val == 1 || val ==7 || val == 10){
            return true;
        }
        else if (val < 10) {
            return false;
        }
        int a = findVal(val);
        boolean b = valDigit(a);
        if(a <10){
            valDigit(a);
        }
        else if(a>1){
            findVal(a);
            return true;
        }
        else {
            return false;
        }
        return b;
    }

    private static boolean valDigit(int a) {
        if(a/10 == 0){
            return false;
        }
        return true;
    }


    private static int findVal(int val) {
        int sum = 0;
        int ld =0;
        while(val>=1){
            ld = val %10;
            sum = sum +  ld * ld;
            val = val/10;

        }
        val = sum;
        return val;
    }
}
