/*
 * Given an integer n and array of integers, returns the Longest Increasing
 * subsequence which is lexicographically smallest corresponding to the indices
 * of the elements.
 * LIS of a given sequence such that all elements of the subsequence are sorted
 * in increasing order.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintingLongestIncreasingSubsequence {
    public static List<Integer> printLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
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

        List<Integer> result = new ArrayList<Integer>();

        result.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(nums[lastIndex]);
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        List<Integer> answer = printLIS(nums);

        System.out.println(answer);
    }
}