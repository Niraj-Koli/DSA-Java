/*
 * Given an integer n and array of integers, returns the Longest Increasing
 * subsequence which is lexicographically smallest corresponding to the indices
 * of the elements.
 * LIS of a given sequence such that all elements of the subsequence are sorted
 * in increasing order.
 */

import java.util.ArrayList;
import java.util.Collections;

class PrintingLongestIncreasingSubsequence {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static ArrayList<Integer> printLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }

        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.println(printLIS(nums));
    }
}