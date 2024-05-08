/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class MaximalRectangle {

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

    // Time -> O(n * m) //
    // Space -> O(m) //

    private static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea = 0;
        int[] histogram = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j] += Character.getNumericValue(matrix[i][j]);
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(histogram));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        System.out.println(maximalRectangle(matrix));
    }
}