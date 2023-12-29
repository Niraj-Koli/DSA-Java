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
import java.util.List;

public class CombinationSumII {
    public static void findCombinations(int[] arr, int target, int index, List<Integer> ds,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            ds.add(arr[i]);
            findCombinations(arr, target - arr[i], i + 1, ds, result);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        findCombinations(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        List<List<Integer>> answer = combinationSum2(candidates, target);

        System.out.println(answer);
    }
}

// class Solution {
// public static void sol(int index, int sum, int target, List<Integer> tmp,
// List<List<Integer>> res,
// int n, int[] arr) {
// if (target == sum) {
// res.add(new ArrayList<>(tmp));
// return;
// }
// if (index >= n || target < sum) {
// return;
// }
// tmp.add(arr[index]);
// sol(index + 1, sum + arr[index], target, tmp, res, n, arr);
// tmp.remove(tmp.size() - 1);
// while (index + 1 < n && arr[index] == arr[index + 1]) {
// index++;
// }
// sol(index + 1, sum, target, tmp, res, n, arr);
// }

// public List<List<Integer>> combinationSum2(int[] arr, int target) {
// List<List<Integer>> res = new ArrayList<>();
// Arrays.sort(arr);
// sol(0, 0, target, new ArrayList<>(), res, arr.length, arr);
// return res;
// }
// }