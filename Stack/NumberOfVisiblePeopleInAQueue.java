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

public class NumberOfVisiblePeopleInAQueue {
    public static int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;

        int[] result = new int[len];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = len - 1; i >= 0; i--) {
            int count = 0;

            if (stack.isEmpty()) {
                result[i] = count;
            } else if (!stack.isEmpty() && stack.peekLast() > heights[i]) {
                result[i] = count + 1;
            } else if (!stack.isEmpty() && stack.peekLast() < heights[i]) {
                while (!stack.isEmpty() && stack.peekLast() < heights[i]) {
                    count++;
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    result[i] = count;
                } else {
                    result[i] = count + 1;
                }
            }

            stack.offerLast(heights[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = { 10, 6, 8, 5, 11, 9 };

        int[] answer = canSeePersonsCount(heights);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// class Solution {
// public int[] canSeePersonsCount(int[] heights) {
// int len = heights.length;

// int[] answer = new int[len];

// for (int i = 0; i < len - 1; i++) {
// int count = 0;
// int max = 0;

// for (int j = i + 1; j < len; j++) {
// if (max < heights[j]) {
// max = Math.max(max, heights[j]);
// count++;
// }

// if (heights[i] < heights[j]) {
// break;
// }
// }

// answer[i] = count;
// }

// return answer;
// }
// }