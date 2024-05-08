/* Find the largest subarray in a given array with sum k */

class LargestSubarrayOfSumKWithPositives {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int largestSubarrayOfSum(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            sum += nums[j];

            while (sum > k) {
                sum -= nums[i];
                i++;
            }

            if (sum == k) {
                res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 1, 9 };
        int k = 10;

        System.out.println(largestSubarrayOfSum(nums, k));
    }
}