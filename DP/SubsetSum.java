/*
 * Given an array of non-negative integers, and a value sum, determine if there
 * is a subset of the given set with sum equal to given sum.
 */

public class SubsetSum {
    public static boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 8, 10 };
        int sum = 11;

        boolean answer = isSubsetSum(nums, sum);

        System.out.println(answer);
    }
}