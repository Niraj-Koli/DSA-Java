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

        int[] t = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev <= i - 1; prev++) {
                if (nums[prev] < nums[i] && 1 + t[prev] > t[i]) {
                    t[i] = 1 + t[prev];
                    hash[i] = prev;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (t[i] > ans) {
                ans = t[i];
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