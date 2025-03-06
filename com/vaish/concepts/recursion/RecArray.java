package com.vaish.concepts.recursion;

import java.util.Collections;

import static java.util.Collections.swap;

public class RecArray {
    public static int[] swapArray(int [] arr, int l, int r) {
        if(l > r){
            return arr;
        }
        swap(arr, l, r);
        swapArray(arr,l+1,r-1);
        return arr;
    }
    public static int[] singleParameter(int[] arr, int l){
        if(l>arr.length/2){
        return arr;
        }
        swap(arr,l , arr.length-l -1);
        singleParameter(arr,l+1);
        return arr;
    }

     public static void  swap(int [] arr ,int l , int r){
        int t = 0;
        t = arr[l];
        arr[l] = arr[r];
        arr[r]= t;
     }
}
