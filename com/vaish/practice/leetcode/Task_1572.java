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
            for(int i =0 ; i<n; i++){
                for(int j =0; j<m; j++){
                    if(i==0 && j==3 || i==1 && j==2 || i==2&& j ==1 || i ==3 && j==0){
                        secondary.add(mat[i][j]);
                    }
                }
            }
        }
        for(int i =0 ; i<n; i++){
            for(int j =0; j<m; j++){
                if(i==0 && j==2 || i== 2 && j==0){
                    secondary.add(mat[i][j]);
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
