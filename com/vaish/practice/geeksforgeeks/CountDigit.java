package com.vaish.practice.geeksforgeeks;

public class CountDigit {
   public static int evenlyDivides(int n) {
       int cnt = 0;
       int d = n;
       while(n>0){

          if(n/d==0){
              cnt++;
          }
           n = n/10;
       }
       return cnt;
    }
}
