/*
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 */

class CombinationSumIV {

    // Time -> O(n * target) //
    // Space -> O(target) //

    private static int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;

        System.out.println(combinationSum4(nums, target));
    }
}