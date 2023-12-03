/*
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 */

public class CountSquareSubmatricesWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += dp[i][j];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 },
        };

        int answer = countSquares(matrix);

        System.out.println(answer);
    }
}

// class Solution {
// public int countSquares(int[][] matrix) {
// int ans = 0;
// for (int i = matrix.length - 2; i >= 0; i--) {
// for (int j = matrix[0].length - 2; j >= 0; j--) {
// if (matrix[i][j] == 1) {
// matrix[i][j] = Math.min(Math.min(matrix[i + 1][j + 1], matrix[i + 1][j]),
// matrix[i][j + 1]) + 1;
// }
// }
// }
// for (int i = matrix.length - 1; i >= 0; i--) {
// for (int j = matrix[0].length - 1; j >= 0; j--) {
// ans += matrix[i][j];
// }
// }
// return ans;
// }
// }