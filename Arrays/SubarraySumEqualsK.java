/*
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.HashMap;

public class SubarraySumEqualsK {

    // Time -> O(n)
    // Space -> O(n)

    private static int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int remove = sum - k;

            count += map.getOrDefault(remove, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 3;

        System.out.println(subarraySum(nums, k));
    }
}