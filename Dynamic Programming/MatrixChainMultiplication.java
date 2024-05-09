/*
 * Given a sequence of matrices, find the most efficient way to multiply these
 * matrices together. The efficient way is the one that involves the least
 * number of multiplications.
 * 
 * The dimensions of the matrices are given in an array arr[] of size N (such
 * that N = number of matrices + 1) where the ith matrix has the dimensions
 * (arr[i-1] x arr[i]).
 */

class MatrixChainMultiplication {

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static int mcm(int[] nums, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = mcm(nums, i, k, dp) + mcm(nums, k + 1, j, dp) + (nums[i - 1] * nums[k] * nums[j]);

            min = Math.min(min, cost);
        }

        dp[i][j] = min;

        return dp[i][j];
    }

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static int matrixChainMultiplication(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int cost = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];

                    cost = Math.min(cost, operations);
                }

                dp[i][j] = cost;
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 40, 20, 30, 10, 30 };

        System.out.println(matrixChainMultiplication(nums));

        int n = nums.length;

        int[][] dp = new int[n][n];

        System.out.println(mcm(nums, 1, n - 1, dp));
    }
}