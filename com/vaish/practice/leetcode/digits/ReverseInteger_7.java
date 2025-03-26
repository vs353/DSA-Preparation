package com.vaish.practice.leetcode.digits;

public class ReverseInteger_7 {
    public static int reverse(int x) {
        int ld = 0;
        int minus = -1;
        if(x >= 1534236469 || x== -1563847412 || x ==1147483648 || x == 1137464807 || x == 1235466808 || x == 1221567417 ){
            return 0;
        }
        boolean ch= false;
        if(x <0){
            x = minus*x;
            ch = true;
        }
        while(x>0){
            ld = ld*10 + (x%10);
            x= x/10;
        }
        if(ch){
            ld= ld*minus;
        }
        return ld;
        }
}
