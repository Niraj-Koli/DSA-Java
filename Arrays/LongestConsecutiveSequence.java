/*
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int element : set) {
            if (!set.contains(element - 1)) {
                int index = element + 1;
                while (set.contains(index)) {
                    index++;
                }
                longest = Math.max(longest, index - element);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };

        int ans = longestConsecutive(nums);

        System.out.println(ans);
    }
}

// class Solution {
// public int longestConsecutive(int[] nums) {
// if (nums.length < 1) {
// return 0;
// }
// int maxi = 0;
// int len = 0;
// Arrays.sort(nums);
// for (int i = 1; i < nums.length; i++) {
// if (nums[i - 1] == nums[i] - 1) {
// len++;
// } else if (nums[i - 1] == nums[i]) {
// continue;
// } else {
// maxi = Math.max(maxi, len);
// len = 0;
// }
// }
// maxi = Math.max(maxi, len);
// System.gc();
// return maxi + 1;
// }
// }