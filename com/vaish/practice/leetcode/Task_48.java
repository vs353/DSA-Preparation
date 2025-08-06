package com.vaish.practice.leetcode;
public class Task_48 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if(n*m != r*c){
            return mat;
        }
        int [][] res = new int[r][c];
        int row =0;
        int col =0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                res[row][col] = mat[i][j];
                col++;
                if(col == c){
                    col=0;
                    row++;
                }
            }
        }
        return res;
    }


    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transpose = new int[m][n];
        for(int i =0; i<n; i++){
            for(int j = 0; j<m ; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }
    private static void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
