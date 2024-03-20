/*
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr. Since the answer may be large, return the
 * answer modulo 109 + 7.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

public class SumOfSubarrayMinimums {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int sumSubarrayMins(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peekLast();
            }
            stack.offer(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                right[i] = stack.peekLast();
            }
            stack.offer(i);
        }

        int mod = (int) (1e9 + 7);

        long res = 0;

        for (int i = 0; i < n; i++) {
            res += (long) (i - left[i]) * (right[i] - i) % mod * nums[i] % mod;
            res %= mod;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };

        System.out.println(sumSubarrayMins(nums));
    }
}