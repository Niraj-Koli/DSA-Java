/*
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 */

class MaxConsecutiveOnesIII {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int zeros = 0;

        int max = 0;

        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (zeros > k) {
                    if (nums[i] == 0) {
                        zeros--;
                    }
                    i++;
                }
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;

        System.out.println(longestOnes(nums, k));
    }
}