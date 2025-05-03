package com.strivers.arrays.easy;

import java.util.Arrays;

public class solution {
    public static boolean isPalindrome(int x) {
        int rev = x;
        int ld= 0;
        if(x<0){
           return  false;
        }
        while(x>0){
            ld = ld* 10+ (x%10);
            x= x/10;
        }
        if(ld==rev){
            return true;
    }
        return false;
}

    public static boolean palindromeCheck(String s) {
        char l = s.charAt(0);
        char r = s.charAt(s.length()-1);
        while(l<r){
            if(l!=r){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void reverse(int[] arr, int n) {
        int s = 0;
        int e = n-1;
        while(s<e){
            int temp;
            temp = arr[s];
            arr[s]= arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        System.out.println(Arrays.toString(arr));
    }

        public static boolean isPalindrome(String s) {
            String ss = s.trim().toLowerCase();
            if(ss==""){
                return true;
            }
            char start = ss.charAt(0);
            char e = ss.charAt(ss.length()-1);
            while(start<=e){
                if(start != e) {
                    return false;
                }
                start++;
                e--;
            }
            return true;
        }

}
