package com.strivers.main;

import com.strivers.arrays.easy.LC_CheckArrayIsSorted_1752;
import com.strivers.arrays.easy.LeftRotate;
import com.strivers.arrays.easy.ZerosLast;

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
        ZerosLast.moveAllZerosToLast(arr);
    }
}
