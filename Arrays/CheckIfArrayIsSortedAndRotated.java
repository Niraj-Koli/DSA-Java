/*
 * Given an array nums, return true if the array was originally sorted in
 * non-decreasing order, then rotated some number of positions (including zero).
 * Otherwise, return false.
 * 
 * There may be duplicates in the original array.
 * 
 * Note: An array A rotated by x positions results in an array B of the same
 * length such that A[i] == B[(i+x) % A.length], where % is the modulo
 * operation.
 */

class CheckIfArrayIsSortedAndRotated {

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean check(int[] nums) {
        int n = nums.length;

        int rotations = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                rotations++;
            }
        }

        if (nums[n - 1] > nums[0]) {
            rotations++;
        }

        return rotations <= 1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };

        System.out.println(check(nums));
    }
}