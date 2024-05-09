/*
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 */

import java.util.ArrayList;
import java.util.Arrays;

class SubsetSumII {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int[] nums, int index, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res) {
        res.add(new ArrayList<Integer>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            ds.add(nums[i]);
            solve(nums, i + 1, ds, res);
            ds.remove(ds.size() - 1);
        }
    }

    private static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        solve(nums, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };

        System.out.println(subsetsWithDup(nums));
    }
}