/* Given an m x n matrix, return all elements of the matrix in spiral order. */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> res = new ArrayList<Integer>();

        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = m - 1;

        int direction = 0;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            switch (direction) {
                case 0: // Right //
                    for (int j = leftCol; j <= rightCol; j++) {
                        res.add(matrix[topRow][j]);
                    }
                    topRow++;
                    break;
                case 1: // Bottom //
                    for (int i = topRow; i <= bottomRow; i++) {
                        res.add(matrix[i][rightCol]);
                    }
                    rightCol--;
                    break;
                case 2: // Left //
                    for (int j = rightCol; j >= leftCol; j--) {
                        res.add(matrix[bottomRow][j]);
                    }
                    bottomRow--;
                    break;
                case 3: // Up //
                    for (int i = bottomRow; i >= topRow; i--) {
                        res.add(matrix[i][leftCol]);
                    }
                    leftCol++;
                    break;
            }
            direction = (direction + 1) % 4;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        List<Integer> ans = spiralOrder(matrix);

        System.out.println(ans);
    }
}

// class Solution {
// public List<Integer> spiralOrder(int[][] arr) {
// List<Integer> integerList = new ArrayList<>();

// int n = arr.length;
// int m = arr[0].length;

// int start_row = 0;
// int end_row = n - 1;
// int start_col = 0;
// int end_col = m - 1;

// while (start_row <= end_row && start_col <= end_col) {
// for (int j = start_col; j <= end_col; j++) {
// integerList.add(arr[start_row][j]);
// }
// for (int i = start_row + 1; i <= end_row; i++) {
// integerList.add(arr[i][end_col]);
// }
// if (start_row < end_row) {
// for (int j = end_col - 1; j >= start_col; j--) {
// integerList.add(arr[end_row][j]);
// }
// }
// if (start_col < end_col) {
// for (int i = end_row - 1; i >= start_row + 1; i--) {
// integerList.add(arr[i][start_col]);
// }
// }

// start_col++;
// start_row++;
// end_col--;
// end_row--;
// }

// return integerList;
// }
// }