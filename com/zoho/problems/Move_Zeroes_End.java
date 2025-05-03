package com.zoho.problems;

import java.util.Arrays;

public class Move_Zeroes_End {
    public static void pushZerosToEnd(int[] arr){
        int s = 0;
        int e = s+1;
        int n = arr.length-1;
        while(s<=n){
            if(arr[s]!=0){
                s++;
//                e++;
                if(arr[s]==0){
                    swap(s,e,arr);
                    s++;
//                    e++;
                }
            }
        }
       /*  int s = 0;
         int e = arr.length-1;
         while(s<e){
             if(arr[e]==0){
                 e--;
             }
             if(arr[s]!=0){
                 s++;
             }
             if(arr[s] ==0 && arr[e]!=0){
                 swap(s,e,arr);
                 s++;
                 e--;
             }
         }

        */
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int s, int e, int[] arr) {
        int temp= 0;
        temp = arr[s];
        arr[s]= arr[e];
        arr[e]= temp;
    }
}
