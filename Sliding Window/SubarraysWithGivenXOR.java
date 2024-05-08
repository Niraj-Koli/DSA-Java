/*
 * Given an array of integers A and an integer B.
 * 
 * Find the total number of subarrays having bitwise XOR of all elements equals
 * to B.
 */

import java.util.HashMap;

class SubarraysWithGivenXOR {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int subarraysWithXor(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int xor = 0;

        map.put(xor, 1);

        int count = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];

            int x = xor ^ k;

            if (map.containsKey(x)) {
                count += map.get(x);
            }

            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarraysWithXor(nums, k));
    }
}