package com.strivers.main;

import com.strivers.arrays.easy.GFG_FindUnion;
import com.strivers.arrays.easy.LC_CheckArrayIsSorted_1752;
import com.strivers.arrays.easy.LeftRotate;
import com.strivers.arrays.easy.ZerosLast;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1,0,2,3,2,0,0,4,5,1};
//        int d = 2;
//        boolean ch = LC_CheckArrayIsSorted_1752.check(arr);
//        System.out.println(ch);
//        LeftRotate.left_Rotate(arr);
//        LeftRotate.right_Rotate(arr);
//        LeftRotate.left_Rotate_DPlace(arr,d);
//        LeftRotate.rotate(arr,d);
//        ZerosLast.moveAllZerosToLast(arr);
//        ZerosLast.optimalSolutinZerosToLast(arr);
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union  = GFG_FindUnion.findUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }
}
