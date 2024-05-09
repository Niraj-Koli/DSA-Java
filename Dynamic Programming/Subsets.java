/*
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 */

import java.util.ArrayList;

class Subsets {

    // Time -> O(2^n * n) //
    // Space -> O(n) //

    private static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        int n = nums.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        System.out.println(subsets(nums));
    }
}