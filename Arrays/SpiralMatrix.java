/* Given an m x n matrix, return all elements of the matrix in spiral order. */

import java.util.ArrayList;

class SpiralMatrix {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer> res = new ArrayList<Integer>();

        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = m - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse right
            for (int j = leftCol; j <= rightCol; j++) {
                res.add(matrix[topRow][j]);
            }
            topRow++;

            // Traverse down
            for (int i = topRow; i <= bottomRow; i++) {
                res.add(matrix[i][rightCol]);
            }
            rightCol--;

            // Traverse left
            if (topRow <= bottomRow) {
                for (int j = rightCol; j >= leftCol; j--) {
                    res.add(matrix[bottomRow][j]);
                }
                bottomRow--;
            }

            // Traverse up
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    res.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        System.out.println(spiralOrder(matrix));
    }
}