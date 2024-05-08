/*
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class LargestRectangleInHistogram {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nextSmallerElementToLeft(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                res[stack.pollLast()] = i;
            }
            stack.offer(i);
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nextSmallerElementToRight(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, n);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                res[stack.pollLast()] = i;
            }
            stack.offer(i);
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = nextSmallerElementToLeft(heights);
        int[] right = nextSmallerElementToRight(heights);

        int[] width = new int[n];

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
        }

        int maxArea = 0;
        int[] area = new int[n];

        for (int i = 0; i < n; i++) {
            area[i] = heights[i] * width[i];

            maxArea = Math.max(maxArea, area[i]);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };

        System.out.println(largestRectangleArea(heights));
    }
}