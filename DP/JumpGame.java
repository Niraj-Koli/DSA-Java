/*
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 */

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        boolean ans = canJump(nums);

        System.out.println(ans);
    }
}

// class Solution {
// public boolean canJump(int[] nums) {
// int max = 0;
// boolean flag = true;
// for (int i = 0; i < nums.length; i++) {
// if (i > max) {
// flag = false;
// break;
// } else {
// max = Math.max(i + nums[i], max);
// }
// }
// System.gc();
// return flag;
// }
// }