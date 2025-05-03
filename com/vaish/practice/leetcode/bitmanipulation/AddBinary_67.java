package com.vaish.practice.leetcode.bitmanipulation;
import java.lang.String;

public class AddBinary_67 {
    public static String addBinary(String a, String b) {
        char a1[] = a.toCharArray();
        char b1[] = b.toCharArray();
        System.out.println(a1);
        System.out.println(b1);
        int num1 = 0;
        int num2 = 0;
        int p = 1;
        for(int i = a1.length-1 ; i>0 ; i--){
            num1 = a1[i]+ (a1[i]*p);
            p= 2*p;
        }
        for(int j = b1.length-1 ; j>0 ; j--){
            num2 = b1[j]+ (b1[j]*p);
            p= 2*p;
        }
       String s =  convertBinaryToString(num1 , num2);

        return s;
    }

    private static String convertBinaryToString(int num1, int num2) {
        int f = num1+ num2;
        String res = "";
        while(f!=1){
            if(f%2==1){
                res +='1';
            }
            else{
                res+='0';
            }
            f =f/2;
        }
       return res;
    }

}
