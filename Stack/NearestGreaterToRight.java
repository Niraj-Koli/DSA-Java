/*
 * The Next greater Element for an element x is the first greater element on the
 * right side of x in the array. Elements for which no greater element exist,
 * consider the next greater element as -1.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class NearestGreaterToRight {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nearestGreaterElementToRight(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                res[stack.pollLast()] = nums[i];
            }
            stack.offer(i);
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nextGreaterElementToRight(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (!stack.isEmpty() && stack.peekLast() > nums[i]) {
                res[i] = stack.peekLast();
            } else if (!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                while (!stack.isEmpty() && stack.peekLast() <= nums[i]) {
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

        int[] ans = nextGreaterElementToRight(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }

        System.out.println();

        int[] output = nearestGreaterElementToRight(nums);

        for (int out : output) {
            System.out.print(out + " ");
        }
    }
}