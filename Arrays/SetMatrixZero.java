/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 */

import java.util.ArrayList;

class SetMatrixZero {
    public static void setZeroes(int[][] matrix) {
        int iterations = 0;

        ArrayList<int[]> indexesPair = new ArrayList<>();

        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;

        for (int index = 0; index < numOfRows * numOfCols; index++) {
            int i = index / numOfCols;
            int j = index % numOfCols;

            if (matrix[i][j] == 0) {
                indexesPair.add(new int[] { i, j });
            }
        }

        while (iterations < indexesPair.size()) {
            int rowIndex = indexesPair.get(iterations)[0];
            int colIndex = indexesPair.get(iterations)[1];

            for (int i = 0; i < numOfRows; i++) {
                matrix[i][colIndex] = 0;
            }

            for (int j = 0; j < numOfCols; j++) {
                matrix[rowIndex][j] = 0;
            }

            iterations++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public void setZeroes(int[][] matrix) {
// int n = matrix.length;
// int m = matrix[0].length;

// int col0 = 1;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (matrix[i][j] == 0) {
// matrix[i][0] = 0;
// if (j != 0) {
// matrix[0][j] = 0;
// } else {
// col0 = 0;
// }
// }
// }
// }

// for (int i = 1; i < n; i++) {
// for (int j = 1; j < m; j++) {
// if (matrix[i][j] != 0) {
// if (matrix[0][j] == 0 || matrix[i][0] == 0) {
// matrix[i][j] = 0;
// }
// }
// }
// }

// if (matrix[0][0] == 0) {
// for (int j = 0; j < m; j++) {
// matrix[0][j] = 0;
// }
// }
// if (col0 == 0) {
// for (int i = 0; i < n; i++) {
// matrix[i][0] = 0;
// }
// }

// }

// }