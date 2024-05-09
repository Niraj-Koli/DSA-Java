/*
 * Given a set of distinct positive integers nums, return the largest subset
 * answer such that every pair (answer[i], answer[j]) of elements in this subset
 * satisfies:
 * 
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class LargestDivisibleSubset {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static ArrayList<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
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
        int[] nums = { 1, 2, 4, 8 };

        System.out.println(largestDivisibleSubset(nums));
    }
}