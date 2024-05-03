/*
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 */

import java.util.HashSet;

class LongestConsecutiveSequence {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static int longestConsecutive(int[] nums) {
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

        System.out.println(longestConsecutive(nums));
    }
}