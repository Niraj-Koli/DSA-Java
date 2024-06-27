/*
 * Given an array of integers, find the closest (not considering distance, but
 * value) smaller on left of every element. If an element has no smaller on the
 * left side, print -1.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class NearestSmallerToLeft {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nearestSmallerElementToLeft(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                res[stack.pollLast()] = nums[i];
            }
            stack.offer(i);
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nextSmallerElementToLeft(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                res[i] = stack.peekLast();
            } else if (!stack.isEmpty() && stack.peekLast() >= nums[i]) {
                while (!stack.isEmpty() && stack.peekLast() >= nums[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peekLast();
                }
            }
            
            stack.offer(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 4 };

        int[] ans = nextSmallerElementToLeft(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }

        System.out.println();

        int[] output = nearestSmallerElementToLeft(nums);

        for (int out : output) {
            System.out.print(out + " ");
        }
    }
}