/*
 * Given a binary array nums and an integer goal, return the number of non-empty
 * subarrays with a sum goal.
 * 
 * A subarray is a contiguous part of the array.
 */

class BinarySubarraysWithSum {

    // Time -> O(2 * n) //
    // Space -> O(1) //

    private static int atMostK(int[] nums, int goal) {
        int n = nums.length;

        int count = 0;
        int sum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            sum += nums[j];

            while (sum > goal && i <= j) {
                sum -= nums[i];
                i++;
            }

            count += j - i + 1;
        }

        return count;
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;

        System.out.println(numSubarraysWithSum(nums, goal));
    }
}