/*
 * Ninja is given an array ‘Arr’ of size ‘N’. You have to help him find the
 * res subarray of ‘Arr’, whose sum is 0. You must return the length of the
 * res subarray whose sum is 0.
 */

import java.util.HashMap;

class LongestSubarrayWithZeroSum {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int getLongestZeroSumSubarrayLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int res = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                res = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    res = Math.max(res, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 1 };

        System.out.println(getLongestZeroSumSubarrayLength(nums));
    }
}