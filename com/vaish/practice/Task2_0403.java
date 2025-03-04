package com.vaish.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_0403 {
   public static void reverseArray(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter Array Size : ");
       int n = sc.nextInt();
       // int t = n;
       int arr[] = new int[n];
       int[] revArr = new int[n];
//       for(int i = 0 ; i< n ; i++){
//           arr[i] = sc.nextInt();
//       }
      for(int i = n - 1; i>= 0; i--){
         arr[i] = sc.nextInt();
      }
       int i = n-1;
       while(i != 0){
           arr[i] =sc.nextInt();
           i--;
       }
       System.out.println(Arrays.toString(arr));
       // revArr[n-1] = arr[0];
       // revArr[n-2] = arr[1];
       // revArr[n-3] = arr[2];
      i = n - 1;
      while(i != 0){
         System.out.println(arr[i);
         i--;
      }
       System.out.println(Arrays.toString(revArr));
   }
}
