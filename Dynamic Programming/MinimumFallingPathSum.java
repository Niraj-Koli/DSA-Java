/*
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 */

class MinimumFallingPathSum {

    // Time -> O((n * m^2) //
    // Space -> O(n * m) //

    private static int solve(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) {
            return (int) Math.pow(10, 9);
        }

        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = solve(i - 1, j, matrix, dp);

        int leftDiagonal = solve(i - 1, j - 1, matrix, dp);
        int rightDiagonal = solve(i - 1, j + 1, matrix, dp);

        dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));

        return dp[i][j];
    }

    private static int getMinPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = solve(n - 1, j, matrix, dp);
            min = Math.min(min, ans);
        }

        return min;
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = dp[i - 1][j];

                int leftDiagonal = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = j + 1 < m ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < m; k++) {
            min = Math.min(min, dp[n - 1][k]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 1, 3 },
                { 6, 5, 4 },
                { 7, 8, 9 }
        };

        System.out.println(minFallingPathSum(matrix));
        System.out.println(getMinPathSum(matrix));
    }
}