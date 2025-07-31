package com.vaish.practice.leetcode;

public class Task_204 {
    public static int countPrimes(int n) {
        int count = 0;
        if (n == 1 || n == 0) {
            return 0;
        }
        for (int i = 2; i < n/2; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}