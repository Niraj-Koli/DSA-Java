/*
 * You are given a 0-indexed integer array nums of even length consisting of an
 * equal number of positive and negative integers.
 * 
 * You should return the array of nums such that the the array follows the given
 * conditions:
 * 
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in
 * nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the
 * aforementioned conditions.
 */

class RearrangeArrayElementsBySign {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int positive = 0;
        int negative = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[positive] = nums[i];
                positive += 2;
            } else {
                res[negative] = nums[i];
                negative += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };

        int[] ans = rearrangeArray(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}