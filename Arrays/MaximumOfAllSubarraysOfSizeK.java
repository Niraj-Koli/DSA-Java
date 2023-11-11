/*
 * Given an array of integers A. There is a sliding window of size B which is
 * moving from the very left of the array to the very right. You can only see
 * the w numbers in the window. Each time the sliding window moves rightwards by
 * one position. You have to find the maximum for each window.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumOfAllSubarraysOfSizeK {
    public static List<Integer> maxSubarrays(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        ArrayList<Integer> support = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        while (j < len) {
            int numAtJ = nums[j];

            support.add(numAtJ);

            if (support.size() == k) {
                int windowMax = Collections.max(support);

                result.add(windowMax);

                support.remove(Integer.valueOf(nums[i]));

                i++;
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        List<Integer> answer = maxSubarrays(nums, k);

        System.out.println(answer);
    }
}
