/*
 * You are given an m x n integer matrix matrix with the following two
 * properties:
 * 
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * Given an integer target, return true if target is in matrix or false
 * otherwise.
 * 
 * You must write a solution in O(log(m * n)) time complexity.
 */

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < m; i++) {
            if (matrix[i][left] <= target && matrix[i][right] >= target) {
                while (left <= right) {
                    int middle = left + (right - left) / 2;

                    if (matrix[i][middle] == target) {
                        return true;
                    } else if (matrix[i][middle] > target) {
                        right = middle - 1;
                    } else if (matrix[i][middle] < target) {
                        left = middle + 1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;

        boolean answer = searchMatrix(matrix, target);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean searchMatrix(int[][] matrix, int target) {
// int n = matrix.length;

// int i = 0;
// int j = n - 1;

// while (i >= 0 && i < n && j >= 0 && j < n) {
// if (matrix[i][j] == target) {
// return true;
// } else if (matrix[i][j] > target) {
// j--;
// } else if (matrix[i][j] < target) {
// i++;
// }
// }

// return false;
// }
// }