/*
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class LongestIncreasingSubsequence {

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int lis(int nums[], int i, int j, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][j + 1] != 0) {
            return dp[i][j + 1];
        }

        int pick = ((j == -1) || nums[i] > nums[j]) ? 1 + lis(nums, i + 1, i, dp) : 0;
        int notPick = lis(nums, i + 1, j, dp);

        dp[i][j + 1] = Math.max(pick, notPick);

        return dp[i][j + 1];
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int lisBinarySearch(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(nums[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                len++;
            } else {
                int index = Collections.binarySearch(list, nums[i]);

                if (index < 0) {
                    index = -index - 1;
                }
                list.set(index, nums[i]);
            }
        }

        return len;
    }

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static int lisSpace(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {

                int pick = ((j == -1) || nums[i] > nums[j]) ? 1 + dp[i + 1][i + 1] : 0;
                int notPick = 0 + dp[i + 1][j + 1];

                dp[i][j + 1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.println(longestIncreasingSubsequence(nums));
        System.out.println(lisSpace(nums));
        System.out.println(lisBinarySearch(nums));

        int n = nums.length;

        int dp[][] = new int[n + 1][n + 1];

        System.out.println(lis(nums, 0, -1, dp));
    }
}