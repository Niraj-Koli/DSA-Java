/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        List<Integer> result = new ArrayList<>();

        for (int num : twoSum(nums, target)) {
            result.add(num);
        }

        System.out.println(result);
    }
}

// LeetCode //

// class Solution {
// public int[] twoSum(int[] nums, int target) {
// int arr[]=new int[2];
// for(int i=0;i<nums.length;i++){
// for(int j=i+1;j<nums.length;j++){
// if(nums[i]+nums[j]==target){
// arr[0]=i;
// arr[1]=j;
// }
// }
// }
// Arrays.sort(arr);
// return arr;
// }
// }