/* Find the largest subarray in a given array with sum k */

public class LargestSubarrayOfSumKWithPositives {

    // Time -> O(n)
    // Space -> O(1)

    private static int largestSubarrayOfSum(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int maxWindow = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxWindow = Math.max(maxWindow, right - left + 1);
            }
        }

        return maxWindow;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 1, 9 };
        int k = 10;

        System.out.println(largestSubarrayOfSum(nums, k));
    }
}