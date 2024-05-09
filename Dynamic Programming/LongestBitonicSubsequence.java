/*
 * Given an array, ‘Arr’ of length ‘n’, find the longest bitonic subsequence. A
 * bitonic subsequence is a subsequence of an array in which the elements can be
 * any of these three:
 * 
 * First, increase till a point and then decrease.
 * Goes on increasing (Longest increasing subsequence)
 * Goes on decreasing (Longest decreasing subsequence)
 */

import java.util.Arrays;

class LongestBitonicSubsequence {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static int longestBitonicSequence(int[] nums) {
        int n = nums.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 11, 2, 10, 4, 5, 2, 1 };

        System.out.println(longestBitonicSequence(nums));
    }
}