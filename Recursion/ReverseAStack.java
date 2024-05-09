/* You are given a stack St. You have to reverse the stack using recursion. */

import java.util.ArrayDeque;

class ReverseAStack {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static void insertAtBottom(ArrayDeque<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.offer(value);
        } else {
            int val = stack.pollLast();

            insertAtBottom(stack, value);
            stack.offer(val);
        }
    }

    private static void reverse(ArrayDeque<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pollLast();

            reverse(stack);
            insertAtBottom(stack, value);
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        stack.offer(4);

        System.out.println(stack);

        reverse(stack);

        System.out.println(stack);
    }
}