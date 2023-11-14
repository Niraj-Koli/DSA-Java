/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < len - 1; i++) {
            int target = nums[i] * -1;

            for (int j = i + 1; j < len; j++) {
                int complement = target - nums[j];

                if (map.containsKey(complement)) {
                    Integer[] arr = { nums[i], nums[j], nums[map.get(complement)] };

                    Arrays.sort(arr);

                    List<Integer> list = Arrays.asList(arr);

                    if (!result.contains(list)) {
                        result.add(new ArrayList<>(list));
                    }
                }
                map.put(nums[j], j);
            }
            map.clear();
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, 4 };

        List<List<Integer>> answer = threeSum(nums);

        System.out.println(answer);
    }
}

// public class Solution {
// public static List<List<Integer>> threeSum(int[] nums) {
// List<List<Integer>> answer = new ArrayList<>();
// Arrays.sort(nums);

// for (int i = 0; i < nums.length - 2; i++) {
// if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
// int low = i + 1;
// int high = nums.length - 1;
// int target = -nums[i];

// while (low < high) {
// if (nums[low] + nums[high] == target) {
// answer.add(Arrays.asList(nums[i], nums[low], nums[high]));

// while (low < high && nums[low] == nums[low + 1])
// low++;
// while (low < high && nums[high] == nums[high - 1])
// high--;

// low++;
// high--;
// } else if (nums[low] + nums[high] < target) {
// low++;
// } else {
// high--;
// }
// }
// }
// }

// return answer;
// }
// }