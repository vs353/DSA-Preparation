package com.vaish.concepts.recursion;

public class RecPalindrome {
    public static boolean isPalindrome(char[] s, int i) {
        int l = s.length;
        if (i >= l / 2) {
            return true;
        }
        if (s[i]!=(s[l - i - 1])) {
            return false;
        }
       return isPalindrome(s, i + 1);

    }
}
