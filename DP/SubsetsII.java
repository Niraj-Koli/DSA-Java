/*
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            Collections.sort(subset);

            if (!result.contains(subset)) {
                result.add(subset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 4, 1, 4 };

        List<List<Integer>> answer = subsetsWithDup(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public List<List<Integer>> subsetsWithDup(int[] nums) {
// List<List<Integer>> lists = new ArrayList<>();
// int count[] = new int[21];
// for (int i = 0; i < nums.length; i++) {
// count[nums[i] + 10]++;
// }
// List<Integer> newList = new ArrayList<>();
// nextStep(count, 0, newList, lists);
// return lists;
// }

// public void nextStep(int[] count, int index, List<Integer> newList,
// List<List<Integer>> lists) {
// if (index == 21) {
// lists.add(new ArrayList<Integer>(newList));
// } else {
// nextStep(count, index + 1, newList, lists);
// for (int i = 1; i <= count[index]; i++) {
// newList = new ArrayList<Integer>(newList);
// newList.add(index - 10);
// nextStep(count, index + 1, newList, lists);
// }
// }
// }
// }