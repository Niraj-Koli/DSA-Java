/*
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 */

class MaxConsecutiveOnes {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int findMaxConsecutiveOnes(int[] nums) {
        int onesSoFar = 0;
        int maxOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                onesSoFar++;
            } else {
                onesSoFar = 0;
            }

            maxOnes = Math.max(maxOnes, onesSoFar);
        }

        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };

        System.out.println(findMaxConsecutiveOnes(nums));
    }
}