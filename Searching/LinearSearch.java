/*
 * You are given an array ‘arr’ containing ‘n’ integers. You are also given an
 * integer ‘num’, and your task is to find whether ‘num’ is present in the array
 * or not.
 * 
 * If ‘num’ is present in the array, return the 0-based index of the first
 * occurrence of ‘num’. Else, return -1.
 */

public class LinearSearch {

    // Time -> O(n)
    // Space -> O(1)

    private static int linearSearch(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 7, 8, 4, 1 };
        int target = 4;

        System.out.println(linearSearch(nums, target));
    }
}