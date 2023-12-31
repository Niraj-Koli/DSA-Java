/*
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void solve(int[] nums, int index, List<List<Integer>> result) {
        int n = nums.length;

        if (index == n) {
            List<Integer> ds = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < n; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        solve(nums, 0, result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> answer = permute(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public List<List<Integer>> permute(int[] nums) {
// List<Integer> currSubset = new ArrayList<>();
// List<List<Integer>> result = new ArrayList<>();
// boolean[] visited = new boolean[nums.length];
// backtrack(nums, currSubset, result, visited);
// return result;
// }

// public void backtrack(int[] nums, List<Integer> currSubset,
// List<List<Integer>> result, boolean[] visited) {
// if (currSubset.size() == nums.length) {
// result.add(new ArrayList<>(currSubset));
// return;
// }

// for (int i = 0; i < nums.length; i++) {
// if (visited[i])
// continue;
// currSubset.add(nums[i]);
// visited[i] = true;
// backtrack(nums, currSubset, result, visited);
// currSubset.remove(currSubset.size() - 1);
// visited[i] = false;
// }
// }
// }