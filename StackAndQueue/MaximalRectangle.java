/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 */

import java.util.ArrayDeque;

public class MaximalRectangle {
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

    public static int maximalRectangle(char[][] matrix) {
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

        int answer = maximalRectangle(matrix);

        System.out.println(answer);
    }
}

// class Solution {
// public int maximalRectangle(char[][] matrix) {
// int currHeights[] = new int[matrix[0].length];
// int maxArea = 0;

// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// if (matrix[i][j] == '1') {
// currHeights[j]++;
// } else {
// currHeights[j] = 0;
// }
// }

// maxArea = Math.max(maxArea, maximumAreaInAHistogram(currHeights));
// }

// return maxArea;
// }

// private static int maximumAreaInAHistogram(int bars[]) {
// if (bars.length == 1) {
// return bars[0];
// }

// Stack<Integer> s = new Stack<>();
// int nextLeftSmall[] = new int[bars.length];
// int nextRightSmall[] = new int[bars.length];

// for (int i = 0; i < bars.length; i++) {
// while (!s.isEmpty() && bars[s.peek()] >= bars[i]) {
// s.pop();
// }

// if (s.isEmpty()) {
// nextLeftSmall[i] = -1;
// } else {
// nextLeftSmall[i] = s.peek();
// }

// s.push(i);
// }

// s = new Stack<>();
// for (int i = bars.length - 1; i >= 0; i--) {
// while (!s.isEmpty() && bars[s.peek()] >= bars[i]) {
// s.pop();
// }

// if (s.isEmpty()) {
// nextRightSmall[i] = bars.length;
// } else {
// nextRightSmall[i] = s.peek();
// }

// s.push(i);
// }

// int largestArea = 0;
// for (int i = 0; i < bars.length; i++) {
// int height = bars[i];
// int width = nextRightSmall[i] - nextLeftSmall[i] - 1;

// largestArea = Math.max(largestArea, height * width);
// }

// System.gc();

// return largestArea;
// }
// }