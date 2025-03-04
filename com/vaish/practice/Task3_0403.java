package com.vaish.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Task3_0403 {
    public static void arraySum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
//        System.out.println(sum(arr));
        System.out.println(sumFromLast(arr));
    }

    public static int sumFromLast(int[] arr) {
        int sum =0;
        int l = arr.length -1;
        for(int i = l; i>=0; i--){
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum = sum+ arr[i];
        }

        return sum;
    }


}
