package com.vaish.practice;

import static java.lang.Math.*;
import static java.time.LocalTime.MAX;

//public class MySqrt {
//    public static int mySqrt(int x){
//
//}
public class MySqrt {
    public static int mySqrt(int x) {
        long s = 0;
        long e = x / 2;
        int ans = 0;
        while(s<=e){
            long m = s + (e-s)/2;
            if(m * m == x){
                return (int) m;
            }else if(m * m < x){
                s = m + 1;
                ans = (int)m;
            }else{
                e = m - 1;
            }
        }
        return ans;
    }
}