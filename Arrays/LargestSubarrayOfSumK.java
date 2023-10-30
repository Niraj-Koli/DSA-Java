/* Find the largest subarray in a given array with sum k */

class LargestSubarrayOfSumK {
    public static int LargestSubarrayOfSum(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        int sum = 0;
        int max = 0;

        while (j < len) {
            sum += nums[j];

            if (sum == k) {
                max = Math.max(max, j - i + 1);
            } else if (sum > k) {
                while (sum > k) {
                    sum -= nums[i];
                    i++;
                }
            }
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 1, 1, 2, 3, 5 };
        int k = 5;

        int result = LargestSubarrayOfSum(nums, k);

        System.out.println(result);
    }
}