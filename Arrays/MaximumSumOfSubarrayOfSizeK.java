/* Find the maximum sum of a subarray with size k */

public class MaximumSumOfSubarrayOfSizeK {
    public static int maxSum(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        int sum = 0;
        int max = 0;

        while (j < len) {
            sum += nums[j];

            if (j - i + 1 == k) {
                max = Math.max(max, sum);

                sum -= nums[i];
                i++;
            }
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 8, 2, 9, 1 };
        int k = 3;

        int answer = maxSum(nums, k);

        System.out.println(answer);
    }
}
