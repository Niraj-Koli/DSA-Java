/*
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int[][] t = new int[1000][1000];

    public static int lis(int nums[], int n, int curr, int prev) {
        if (curr == n) {
            return 0;
        }

        if (t[curr][prev + 1] != 0) {
            return t[curr][prev + 1];
        }

        int pick = ((prev == -1) || nums[curr] > nums[prev]) ? 1 + lis(nums, n, curr + 1, curr) : 0;
        int notPick = 0 + lis(nums, n, curr + 1, prev);

        t[curr][prev + 1] = Math.max(pick, notPick);

        return t[curr][prev + 1];
    }

    public static int lisBinarySearch(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);

                len++;
            } else {
                int index = Collections.binarySearch(list, nums[i]);

                if (index < 0) {
                    index = -index - 1;
                }

                list.set(index, nums[i]);
            }
        }
        return len;
    }

    public static int lisSpace(int[] nums) {
        int n = nums.length;

        int t[] = new int[n];
        Arrays.fill(t, 1);

        for (int i = 0; i <= n - 1; i++) {
            for (int prev = 0; prev <= i - 1; prev++) {

                if (nums[prev] < nums[i]) {
                    t[i] = Math.max(t[i], 1 + t[prev]);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, t[i]);
        }

        return max;
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;

        int t[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {

                int pick = ((prev == -1) || nums[curr] > nums[prev]) ? 1 + t[curr + 1][curr + 1] : 0;
                int notPick = 0 + t[curr + 1][prev + 1];

                t[curr][prev + 1] = Math.max(pick, notPick);
            }
        }

        return t[0][0];
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        int answer = longestIncreasingSubsequence(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int lengthOfLIS(int[] nums) {
// int n = nums.length;
// List<Integer> list = new ArrayList<>();
// list.add(nums[0]);
// for (int i = 1; i < n; i++) {
// if (nums[i] > list.get(list.size() - 1)) {
// list.add(nums[i]);
// } else {
// list.set(f(list, nums[i]), nums[i]);
// }
// }
// return list.size();
// }

// public int f(List<Integer> list, int element) {
// int left = 0;
// int right = list.size() - 1;
// int index = -1;
// while (left <= right) {
// int mid = left + (right - left) / 2;
// if (list.get(mid) < element) {
// left = mid + 1;
// } else {
// right = mid - 1;
// index = mid;
// }
// }
// return index;
// }
// }