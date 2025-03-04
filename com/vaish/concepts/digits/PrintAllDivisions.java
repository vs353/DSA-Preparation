package com.vaish.concepts.digits;

public class PrintAllDivisions {
    public static void  printDivisions(int n){
//        int count = 0;
        for(int i =2; i<n ; i++){
            for(int j = i ; j<=i ; j++){
                if(j % i == 0){
//                count ++;
                    System.out.print(i + " ");
                }
            }

//            return count;
        }
    }
}
