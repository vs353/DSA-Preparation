package com.vaish.practice.leetcode;
public class Task_48 {
    public static int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        for (int i = 0; i < row; i++) {
            reverse(image[i]);
        }
        int one = 1;
        int zero =0;
        for(int i =0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(image[i][j] == zero){
                    image[i][j] = one;
                } else if (image[i][j] == one) {
                    image[i][j] =zero;
                }
            }
        }
        return image;
    }
    private static void reverse(int[] ints) {
        int l = 0, r = ints.length - 1;
        while (l < r) {
            int temp = ints[l];
            ints[l] = ints[r];
            ints[r] = temp;
            l++;
            r--;
        }
    }
        public static int[][] matrixReshape ( int[][] mat, int r, int c){
            int n = mat.length;
            int m = mat[0].length;
            int[][] arr = new int[r][c];
            int row = 0;
            int col = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[row][col] = mat[i][j];
                    col++;
                    if (col == c) {
                        col = 0;
                        r++;
                    }
                }
            }
            return arr;
        }


        public static int[][] transpose ( int[][] matrix){
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] transpose = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            return transpose;
        }

        public static void rotate ( int[][] matrix){
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
        private static void reverseRow ( int[] row){
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
