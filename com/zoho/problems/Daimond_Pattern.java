package com.zoho.problems;

public class Daimond_Pattern {
//    int n = 4;

   public static void pattern28(int n ){
       for(int row = 0; row<2*n ; row++){
           int totalColsInRow  = row > n ? 2* n -row : row;
           int noOfSpace = n - totalColsInRow;
           for(int s = 0; s<noOfSpace;s++){
               System.out.println(" ");
           }
           for( int col = 0 ; col<totalColsInRow; col++){
               System.out.println("* ");
           }
           System.out.println();
       }
   }
   public static void  daimondPattern(int n){
       // Upper half
       for (int i = 1; i <= n; i++) {
           // Print spaces
           for (int j = i; j < n; j++) {
               System.out.print(" ");
           }
           // Print stars
           for (int j = 1; j <= (2*i-1); j++) {
               System.out.print("*");
           }
           System.out.println();
       }

       // Lower half
       for (int i = n-1; i >= 1; i--) {
           // Print spaces
           for (int j = n; j > i; j--) {
               System.out.print(" ");
           }
           // Print stars
           for (int j = 1; j <= (2*i-1); j++) {
               System.out.print("*");
           }
           System.out.println();
       }
   }

}
