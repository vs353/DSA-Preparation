package com.vaish.concepts.digits;

public class CheckForPrime {
    public static boolean isPrime(int n) {
        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                count++;
//            }
//        }
        for(int i =1 ; i*i<= n; i++){
            if(n%i ==0){
                count++;
                if((n/i) !=i){
                    count++;
                }
            }
        }
        if (count <= 2) {
            return true;
        } else {
            return false;
        }
    }
}
