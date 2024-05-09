/*
 * You are given an array 'A' of 'N' integers. You have to return true if there
 * exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return
 * false.
 */

class SubsetSumIII {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static boolean solve(int[] nums, int k, int index, int sum) {
        if (sum == k) {
            return true;
        }
        if (index == nums.length || sum > k) {
            return false;
        }

        if (solve(nums, k, index + 1, sum + nums[index])) {
            return true;
        }

        return solve(nums, k, index + 1, sum);
    }

    private static boolean isSubsetPresent(int[] nums, int k) {
        return solve(nums, k, 1, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 6, 7 };
        int k = 14;

        System.out.println(isSubsetPresent(nums, k));
    }
}