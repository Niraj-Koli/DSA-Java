/*
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 */

// x ^ x = 0 //
// x ^ 0 = x //

class DistinctNumber {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int singleNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2, 3, 5, 4, 5 };

        System.out.println(singleNumber(nums));
    }

}