package com.vaish.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Task1_0403 {
        public static void gettingArrayFromUser(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Array Size : ");
            int n = sc.nextInt();
            int [] arr = new int[n];
//            for(int i = 0; i<n ; i++){
//                arr[i] = sc.nextInt();
//            }
            int i = 0;
            while(n!=0){
                arr[i] = sc.nextInt();
                i++;
                n--;
            }

            for(int j = 0 ; j < arr.length ; j++){
                System.out.println("Array Element : " + arr[j]);
            }
        }
}
