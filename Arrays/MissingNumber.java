/*
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 */

class MissingNumber {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int missingNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;
        int index = 0;

        for (index = 0; index < n; index++) {
            xor ^= index ^ nums[index];
        }

        return xor ^ index;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

        System.out.println(missingNumber(nums));
    }
}