/*
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 */

class SingleNumber {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };

        System.out.println(singleNumber(nums));
    }
}