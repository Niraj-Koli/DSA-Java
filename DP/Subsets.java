/*
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> answer = subsets(nums);

        System.out.println(answer);
    }
}

// class Solution {
// List<List<Integer>> ans = new ArrayList<>();
// List<Integer> result = new ArrayList<>();

// public List<List<Integer>> subsets(int[] nums) {

// sub(0, nums);
// return ans;
// }

// public void sub(int index, int[] nums) {
// if (index == nums.length) {
// ans.add(new ArrayList(result));
// return;
// }
// result.add(nums[index]); // include
// sub(index + 1, nums);

// result.remove(result.size() - 1); // exclude
// sub(index + 1, nums);
// }
// }