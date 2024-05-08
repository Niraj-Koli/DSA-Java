/*
 * Given an integer array nums and an integer k, return the number of good
 * subarrays of nums.
 * 
 * A good array is an array where the number of different integers in that array
 * is exactly k.
 * 
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 */

import java.util.HashMap;

class SubarraysWithKDifferentIntegers {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int atMostK(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            res += j - i + 1;
        }
        return res;
    }

    private static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }
}