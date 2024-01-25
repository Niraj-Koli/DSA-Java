/*
 * Given a 2D integer array matrix, return the transpose of matrix.
 * 
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 */

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };

        int[][] answer = transpose(matrix);

        for (int[] row : answer) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public int[][] transpose(int[][] matrix) {
// int[][] op = new int[matrix[0].length][matrix.length];
// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// op[j][i] = matrix[i][j];
// }
// }
// return op;

// }
// }