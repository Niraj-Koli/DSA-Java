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
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
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
        int[] nums = { 1, 2, 4, 8 };

        List<Integer> answer = largestDivisibleSubset(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public List<Integer> largestDivisibleSubset(int[] nums) {
// int n = nums.length;
// int[] count = new int[n];
// int[] dp = new int[n];
// Arrays.sort(nums);
// int max = 0, index = -1;
// for (int i = 0; i < n; i++) {
// count[i] = 1;
// dp[i] = -1;
// for (int j = i - 1; j >= 0; j--) {
// if (nums[i] % nums[j] == 0) {
// if (1 + count[j] > count[i]) {
// count[i] = count[j] + 1;
// dp[i] = j;
// }
// }
// }
// if (count[i] > max) {
// max = count[i];
// index = i;
// }
// }
// List<Integer> res = new ArrayList<>();
// while (index != -1) {
// res.add(nums[index]);
// index = dp[index];
// }
// return res;
// }
// }