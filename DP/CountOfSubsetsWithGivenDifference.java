/*
 * Given an array arr[] of size N and a given difference diff, the task is to
 * count the number of partitions that we can perform such that the difference
 * between the sum of the two subsets is equal to the given difference.
 */

public class CountOfSubsetsWithGivenDifference {
    public static int countOfSubsetsDifference(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;

        for (int val : nums) {
            totalSum += val;
        }

        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int sum = (totalSum + target) / 2;

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = 0;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3 };
        int target = 1;

        int answer = countOfSubsetsDifference(nums, target);

        System.out.println(answer);
    }
}