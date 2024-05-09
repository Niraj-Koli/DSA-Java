/*
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor, divide all the array by it, and sum the division's
 * result. Find the smallest divisor such that the result mentioned above is
 * less than or equal to threshold.
 * 
 * Each result of the division is rounded to the nearest integer greater than or
 * equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 * The test cases are generated so that there will be an answer.
 */

class FindTheSmallestDivisorGivenAThreshold {

    // Time -> O(n * log(max)) //
    // Space -> O(1) //

    private static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    private static int divisonSum(int[] nums, int divisor) {
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) nums[i] / (double) divisor);
        }

        return sum;
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = findMax(nums);

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int sum = divisonSum(nums, mid);

            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}