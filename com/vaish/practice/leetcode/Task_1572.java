package com.vaish.practice.leetcode;

import java.util.ArrayList;

public class Task_1572 {
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> primary = new ArrayList<>();
        for(int i =0 ; i<n; i++){
            for(int j =0; j<m; j++){
                if(i==j){
                    primary.add(mat[i][j]);
                }
            }
        }
        ArrayList<Integer> secondary = new ArrayList<>();
        if(n%2==0){
            for(int i =0; i<n; i++){
                for(int j =0 ; j<n; j++){
                    if(i+j==n-1){
                        secondary.add(mat[i][j]);
                    }
                }
            }
        }
        else{
            for(int i =0 ; i<n; i++){
                for(int j =0; j<m; j++){
                    if(i+j==n-1 && i!=j){
                        secondary.add(mat[i][j]);
                    }
                }
            }
        }
        int add = 0;
        for(int i =0; i< primary.size();i++){
            add= add+ primary.get(i);
        }
        for (int i =0; i<secondary.size(); i++){
            add = add+ secondary.get(i);
        }
        return add;
    }
}
