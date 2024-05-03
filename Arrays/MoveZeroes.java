/*
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 */

class MoveZeroes {

    // Time -> O(n) //
    // Space -> O(1) //

    private static void moveZeroes(int[] nums) {
        int n = nums.length;

        int snowBalls = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                snowBalls++;
            } else if (snowBalls > 0) {
                nums[i - snowBalls] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}