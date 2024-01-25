/*
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 */

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 },
        };

        rotate(matrix);

        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public void rotate(int[][] matrix) {
// int n = matrix.length;
// int j = 0;
// while (j < n) {
// reverse(matrix, 0, j, n - 1, j);
// j++;
// }
// int i1 = 0;
// int j1 = 0;
// int i2 = 0;
// int j2 = 0;
// while (i1 < n) {
// daignol(matrix, i1, i2, j1, j2);
// i1++;
// j2++;
// }
// j2--;
// i1--;
// while (i2 < n) {
// i2++;
// j1++;
// if (i2 >= n) {
// break;
// }
// daignol(matrix, i1, i2, j1, j2);
// }

// }

// public void daignol(int[][] matrix, int i1, int j1, int i2, int j2) {
// while (i2 < i1) {
// swap(matrix, i1, i2, j1, j2);
// i1--;
// j1++;
// i2++;
// j2--;
// }
// }

// public void reverse(int[][] matrix, int i1, int j1, int i2, int j2) {
// while (i1 < i2) {
// swap(matrix, i1, i2, j1, j2);
// i1++;
// i2--;
// }
// }

// public void swap(int[][] matrix, int i1, int i2, int j1, int j2) {
// int temp = matrix[i1][j1];
// matrix[i1][j1] = matrix[i2][j2];
// matrix[i2][j2] = temp;
// }
// }