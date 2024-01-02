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
import java.util.List;

public class SubsetSumII {
    public static void findSubsets(int[] nums, int index, List<Integer> ds, List<List<Integer>> result) {
        result.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            ds.add(nums[i]);
            findSubsets(nums, i + 1, ds, result);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        findSubsets(nums, 0, new ArrayList<Integer>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };

        List<List<Integer>> answer = subsetsWithDup(nums);

        System.out.println(answer);
    }
}