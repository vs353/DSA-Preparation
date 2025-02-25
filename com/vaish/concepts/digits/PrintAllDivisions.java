package com.vaish.concepts.digits;

public class PrintAllDivisions {
    public static void  printDivisions(int n){
        for(int i =1; i<=n ; i++){
            if(n%i ==0 ){
                System.out.print(i + " ");
            }
        }
    }
}
