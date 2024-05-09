/*
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 */

import java.util.Collections;
import java.util.ArrayList;

class SubsetsII {

    // Time -> O(2^n * n * log(n)) //
    // Space -> O(2^n * n) //

    private static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            Collections.sort(subset);

            if (!res.contains(subset)) {
                res.add(subset);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 4, 1, 4 };

        System.out.println(subsetsWithDup(nums));
    }
}