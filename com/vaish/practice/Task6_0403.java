package com.vaish.practice;

public class Task6_0403 {
    public static void  evenNumInArray(){
        int[] arr = {1,2,3,4,5,6};
        int evenSum = 0;
        for(int i = 0; i< arr.length; i++){
           if(arr[i]%2 ==0){
               evenSum = evenSum + arr[i];
               System.out.println(arr[i]);
           }
       }
        // Using While Loop
        System.out.println(evenSum);
        int revEvenSum =0;
        for(int i = arr.length-1 ; i>=0; i--){
            if(arr[i]%2 ==0){
                revEvenSum = revEvenSum + arr[i];
                System.out.println(arr[i]);
            }
        }
        System.out.println(revEvenSum);
    }
     public static void oddNumInArray(){
         int[] arr = {1,2,3,4,5,6};
         int oddSum = 0;
         int revOddSum = 0;
         for( int i =0 ; i<arr.length ; i++){
             if(arr[i] % 2 !=0){
                 oddSum = oddSum + arr[i];
                 System.out.println(arr[i]);
             }
         }
         System.out.println(oddSum);

         for( int i = arr.length - 1 ; i >=0 ; i--){
             if(arr[i]%2!= 0){
                 revOddSum= revOddSum + arr[i];
                 System.out.println(arr[i]);
             }
         }
         System.out.println(revOddSum);
     }

}
