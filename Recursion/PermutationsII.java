/*
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 */

import java.util.ArrayList;
import java.util.HashSet;

class PermutationsII {
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // Time -> O(n!) //
    // Space -> O(n!) //

    private static void solve(int[] nums, int index, HashSet<ArrayList<Integer>> res) {
        int n = nums.length;

        if (index == n) {
            ArrayList<Integer> ds = new ArrayList<Integer>();

            for (int number : nums) {
                ds.add(number);
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

    private static ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();

        solve(nums, 0, res);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(res);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

        System.out.println(permuteUnique(nums));
    }
}