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

        int i = 0;
        int j = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }
        }

        return j - i;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;

        System.out.println(longestOnes(nums, k));
    }
}