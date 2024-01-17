/*
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 */

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
    public static int[] nextSmallerElementToLeft(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else if (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                result[i] = stack.peekLast();
            } else if (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peekLast();
                }
            }
            stack.offerLast(i);
        }
        return result;
    }

    public static int[] nextSmallerElementToRight(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = n;
            } else if (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                result[i] = stack.peekLast();
            } else if (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    result[i] = n;
                } else {
                    result[i] = stack.peekLast();
                }
            }
            stack.offerLast(i);
        }
        return result;
    }

    public static int largestRectangleArea(int[] heights) {
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

        int answer = largestRectangleArea(heights);

        System.out.println(answer);
    }
}

// class Solution {
// public int largestRectangleArea(int[] heights) {
// int noOfBar = heights.length;
// int maxArea = 0;

// int[] stack = new int[heights.length];
// int top = -1; // acts as stack's top pointer
// int areaWithTop;
// int i = 0;
// while (i < heights.length) {
// if (top == -1 || heights[i] >= heights[stack[top]]) {
// stack[++top] = i++;
// } else {
// int topOfStack = stack[top--];
// areaWithTop = heights[topOfStack] * (top == -1 ? i : i - stack[top] - 1);
// maxArea = Math.max(maxArea, areaWithTop);
// }
// }

// while (top >= 0) {
// int topOfStack = stack[top--];
// areaWithTop = heights[topOfStack] * (top == -1 ? i : i - stack[top] - 1);
// maxArea = Math.max(maxArea, areaWithTop);
// }
// System.gc();

// return maxArea;
// }
// }