package com.vaish.concepts.digits;

import static java.lang.Math.log10;

public class CountDigits {
   // int n = 7789;
    public static int countDigits(int n){
        int count= 0;
   //  while(n>0){
         //int lastDigit = n %10;
         count = (int) (log10(n)+1);
        // count++;
       //  System.out.println(lastDigit);
         n = n /10;
 //    }
     return count;
    }
}

