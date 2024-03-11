/*
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k.
 * 
 * Return the kth positive integer that is missing from this array.
 */

public class KthMissingPositiveNumber {

    // Time -> O(log(n))
    // Space -> O(1)

    private static int findKthPositive(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int missing = nums[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return k + right + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 7, 11 };
        int k = 5;

        System.out.println(findKthPositive(nums, k));
    }
}