package com.vaish.concepts.digits;

public class PalindromeNumber {
    public static boolean palindromeNumbers(int n) {
        int rev = 0;
        int org = n;
        while (n > 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }
        return org == rev;
    }
}
