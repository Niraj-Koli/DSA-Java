/*
 * Given a sequence of matrices, find the most efficient way to multiply these
 * matrices together. The efficient way is the one that involves the least
 * number of multiplications.
 * 
 * The dimensions of the matrices are given in an array arr[] of size N (such
 * that N = number of matrices + 1) where the ith matrix has the dimensions
 * (arr[i-1] x arr[i]).
 */

public class MatrixChainMultiplication {
    public static int[][] t;

    public static int matrixChainMultiplicationRecursive(int[] nums) {
        int n = nums.length;

        t = new int[n][n];

        return mcm(nums, 1, n - 1);
    }

    public static int mcm(int[] nums, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (t[i][j] != 0) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost = mcm(nums, i, k) + mcm(nums, k + 1, j) + (nums[i - 1] * nums[k] * nums[j]);

            min = Math.min(min, cost);
        }

        t[i][j] = min;

        return t[i][j];
    }

    public static int matrixChainMultiplicationIterative(int[] nums) {
        int n = nums.length;

        int[][] t = new int[n + 1][n + 1];

        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;

                t[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = t[i][k] + t[k + 1][j] + (nums[i - 1] * nums[k] * nums[j]);

                    if (cost < t[i][j]) {
                        t[i][j] = cost;
                    }
                }
            }
        }

        return t[1][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 40, 20, 30, 10, 30 };

        int answer = matrixChainMultiplicationRecursive(nums);

        System.out.println(answer);
    }
}