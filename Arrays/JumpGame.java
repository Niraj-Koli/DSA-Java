/*
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 */

class JumpGame {

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean canJump(int[] nums) {
        int n = nums.length;

        int i = 0;
        for (int reach = 0; i < n && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }

        return i == n;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(canJump(nums));
    }
}