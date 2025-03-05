package com.vaish.concepts.recursion;

public class RecPrintName {
    public static void printNames(int i,int n){
        if(i>n){
            return;
        }
        System.out.println("salo");
        printNames(i+1, n);
    }
}
