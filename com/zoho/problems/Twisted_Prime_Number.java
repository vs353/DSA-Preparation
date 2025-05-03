package com.zoho.problems;

public class Twisted_Prime_Number {
    public static int isTwistedPrime(int N) {
        boolean ans =  count(N);
        int rev=0;
        while(N>0){
            int digit = N % 10;         // Get last digit
            rev = rev * 10 + digit; // Append digit to reversed number
            N /= 10;
        }

        boolean ans2 = count(rev);
        if(ans && ans2 == true){
            return 1;
        }
        return 0;
    }
    public static boolean count(int N){
        int count = 0;
        boolean flag = false;
        int i = 2;
        while(i<=N){
            if(N%i==0){
                count++;
            }
            i++;
        }
        if(count==1){
            flag= true;
        }
        return flag;
    }
}
