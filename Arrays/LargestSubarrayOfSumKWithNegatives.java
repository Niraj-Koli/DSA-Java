/* Find the largest subarray in a given array with sum k */

import java.util.HashMap;

public class LargestSubarrayOfSumKWithNegatives {

    // Time -> O(n)
    // Space -> O(n)

    private static int largestSubarrayOfSum(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int maxWindow = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == k) {
                maxWindow = Math.max(maxWindow, i + 1);
            }

            if (map.containsKey(sum - k)) {
                maxWindow = Math.max(maxWindow, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxWindow;
    }

    public static void main(String[] args) {
        int[] nums = { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
        int k = 15;

        System.out.println(largestSubarrayOfSum(nums, k));
    }
}