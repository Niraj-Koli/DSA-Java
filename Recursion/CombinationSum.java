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
import java.util.List;

public class CombinationSum {
    public static void findCombinations(int[] arr, int target, int index, List<Integer> ds,
            List<List<Integer>> result) {
        if (index == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(arr, target - arr[index], index, ds, result);
            ds.remove(ds.size() - 1);
        }
        findCombinations(arr, target, index + 1, ds, result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        findCombinations(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        List<List<Integer>> answer = combinationSum(candidates, target);

        System.out.println(answer);
    }
}

// class Solution {
// private List<List<Integer>> combinations = new ArrayList<>();

// public List<List<Integer>> combinationSum(int[] candidates, int target) {
// makeCombs(new ArrayList<>(), candidates, 0, target, 0);
// System.gc();
// return combinations;
// }

// private void makeCombs(List<Integer> comb, int[] nums, int sum, int target,
// int idx) {
// if (sum == target) {
// combinations.add(new ArrayList<>(comb));
// } else {
// for (int i = idx; i < nums.length; i++) {
// if (sum + nums[i] <= target) {
// comb.add(nums[i]);
// makeCombs(comb, nums, sum + nums[i], target, i);
// comb.remove(comb.size() - 1);
// }
// }
// }
// }
// }