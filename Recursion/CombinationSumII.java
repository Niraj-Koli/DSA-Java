/*
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 */

import java.util.ArrayList;
import java.util.Arrays;

class CombinationSumII {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int[] nums, int target, int index, ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            ds.add(nums[i]);
            solve(nums, target - nums[i], i + 1, ds, res);
            ds.remove(ds.size() - 1);
        }
    }

    private static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(candidates);

        solve(candidates, target, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
    }
}