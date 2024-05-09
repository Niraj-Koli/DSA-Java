/*
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 */

import java.util.ArrayList;

class Permutations {
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // Time -> O(n! * n) //
    // Space -> O(n!) //

    private static void solve(int[] nums, int index, ArrayList<ArrayList<Integer>> res) {
        int n = nums.length;

        if (index == n) {
            ArrayList<Integer> ds = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                ds.add(nums[i]);
            }
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < n; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    private static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        solve(nums, 0, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        System.out.println(permute(nums));
    }
}