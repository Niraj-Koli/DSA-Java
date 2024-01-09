/*
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 */

// x ^ x = 0 //
// x ^ 0 = x //

public class DistinctNumber {
    public static int singleNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2, 3, 5, 4, 5 };

        int answer = singleNumber(nums);

        System.out.println(answer);
    }

}

// class Solution {
// public int singleNumber(int[] nums) {
// int n = nums.length, res = 0, i = 0;
// while (i != n) {
// res ^= nums[i];
// i++;
// }
// return res;
// }
// }