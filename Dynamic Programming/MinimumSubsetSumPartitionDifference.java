/*
 * Given an array arr of size n containing non-negative integers, the task is to
 * divide it into two sets S1 and S2 such that the absolute difference between
 * their sums is minimum and find the minimum difference
 */

class MinimumSubsetSumPartitionDifference {

    // Time -> O(n * sum) //
    // Space -> O(n * sum) //

    private static int minDifference(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

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

        int min = Integer.MAX_VALUE;

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                min = sum - 2 * j;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 6, 6, 5, 7, 4, 7, 6 };

        System.out.println(minDifference(nums));
    }
}