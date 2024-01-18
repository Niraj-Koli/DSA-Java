/*
 * Given an array of integers, find the closest (not considering distance, but
 * value) smaller on rightof every element. If an element has no smaller on the
 * right side, print -1.
 */

import java.util.ArrayDeque;

public class NearestSmallerToRight {
    public static int[] nextSmallerElementToRight(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else if (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                result[i] = stack.peekLast();
            } else if (!stack.isEmpty() && stack.peekLast() >= nums[i]) {
                while (!stack.isEmpty() && stack.peekLast() >= nums[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peekLast();
                }
            }
            stack.offerLast(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 4 };

        int[] answer = nextSmallerElementToRight(nums);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

}