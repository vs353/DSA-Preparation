package com.vaish.practice;

public class Task4_0403 {
    public static void evenIndex(){
        int[] arr = {1,2,3,4,5,6};
        int s = 0;
        for(int i =0 ; i < arr.length ; i++){
            if(i%2 == 0){
                s = s + arr[i];
                System.out.println(arr[i]);
            }
        }
        System.out.println(s);
        int sum =0;
        for(int i = arr.length-1; i >=0; i--){
            if(i%2==0){
              sum = sum + arr[i];
            }
        }
        System.out.println(sum);
    }
}
