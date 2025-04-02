package com.strivers.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZerosLast {
    public static void moveAllZerosToLast(int[] arr){
        int n = arr.length-1;
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i<=n; i++){
            if(arr[i]!=0){
           temp.add(arr[i]);
            }
        }
        for(int i = 0; i<temp.size();i++){
            arr[i] = temp.get(i);
        }
       int noOfZeros = temp.size();
        for(int i =noOfZeros;i<=n;i++){
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
