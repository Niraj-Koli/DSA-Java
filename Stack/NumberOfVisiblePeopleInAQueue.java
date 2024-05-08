/*
 * There are n people standing in a queue, and they numbered from 0 to n - 1 in
 * left to right order. You are given an array heights of distinct integers
 * where heights[i] represents the height of the ith person.
 * 
 * A person can see another person to their right in the queue if everybody in
 * between is shorter than both of them. More formally, the ith person can see
 * the jth person if i < j and min(heights[i], heights[j]) > max(heights[i+1],
 * heights[i+2], ..., heights[j-1]).
 * 
 * Return an array answer of length n where answer[i] is the number of people
 * the ith person can see to their right in the queue.
 */

import java.util.ArrayDeque;

class NumberOfVisiblePeopleInAQueue {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;

        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            if (stack.isEmpty()) {
                res[i] = count;
            } else if (!stack.isEmpty() && stack.peekLast() > heights[i]) {
                res[i] = count + 1;
            } else if (!stack.isEmpty() && stack.peekLast() < heights[i]) {
                while (!stack.isEmpty() && stack.peekLast() < heights[i]) {
                    stack.pollLast();
                    count++;
                }

                if (stack.isEmpty()) {
                    res[i] = count;
                } else {
                    res[i] = count + 1;
                }
            }

            stack.offer(heights[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = { 10, 6, 8, 5, 11, 9 };

        int[] ans = canSeePersonsCount(heights);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}