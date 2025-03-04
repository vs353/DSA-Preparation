package com.vaish.practice;

public class Pattern {
   // int n = 3;

    public static void isPattern(int n) {
        for(int i = 0; i<=n; i++){
            for(int j = i ; j<=n ; j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

}
