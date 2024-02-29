/*
 * Ninja is given an array ‘Arr’ of size ‘N’. You have to help him find the
 * longest subarray of ‘Arr’, whose sum is 0. You must return the length of the
 * longest subarray whose sum is 0.
 */

import java.util.HashMap;

public class LongestSubarrayWithZeroSum {

    // Time -> O(n)
    // Space -> O(n)

    private static int getLongestZeroSumSubarrayLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int longest = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                longest = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    longest = Math.max(longest, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 1 };

        System.out.println(getLongestZeroSumSubarrayLength(nums));
    }
}