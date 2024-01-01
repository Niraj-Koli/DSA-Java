/*
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void solve(int[] nums, int index, Set<List<Integer>> result) {
        int n = nums.length;

        if (index == n) {
            List<Integer> ds = new ArrayList<Integer>();

            for (int number : nums) {
                ds.add(number);
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

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        solve(nums, 0, result);

        List<List<Integer>> answer = new ArrayList<List<Integer>>(result);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

        List<List<Integer>> answer = permuteUnique(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public static List<List<Integer>> permuteUnique(int[] nums) {
// List<List<Integer>> ans = new ArrayList<>();
// if (nums == null || nums.length == 0) {
// return ans;
// }

// int l = nums.length;
// process(nums, l - 1, ans);
// return ans;
// }

// public static void process(int[] nums, int i, List<List<Integer>> ans) {
// if (i == 0) {
// List<Integer> t = new ArrayList<>();
// for (int n : nums) {
// t.add(n);
// }
// ans.add(t);
// return;
// }

// boolean[] isUsed = new boolean[21];
// for (int j = i; j != -1; j--) {
// int p = nums[j] + 10;
// if (isUsed[p]) {
// continue;
// }
// isUsed[p] = true;
// swap(nums, i, j);
// process(nums, i - 1, ans);
// swap(nums, i, j);
// }
// }

// public static void swap(int[] nums, int i, int j) {
// int t = nums[i];
// nums[i] = nums[j];
// nums[j] = t;
// }
// }