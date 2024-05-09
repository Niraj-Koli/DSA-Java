/*
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations that
 * sum up to target is less than 150 combinations for the given input.
 */

import java.util.ArrayList;

class CombinationSum {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int[] nums, int target, int index, ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> res) {
        if (index == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(ds));
            }
            return;
        }

        if (nums[index] <= target) {
            ds.add(nums[index]);
            solve(nums, target - nums[index], index, ds, res);
            ds.remove(ds.size() - 1);
        }

        solve(nums, target, index + 1, ds, res);
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        solve(candidates, target, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }
}