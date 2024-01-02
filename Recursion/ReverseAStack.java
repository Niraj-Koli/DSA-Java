/* You are given a stack St. You have to reverse the stack using recursion. */

import java.util.ArrayDeque;

public class ReverseAStack {
    public static void reverse(ArrayDeque<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pollLast();
            reverse(stack);
            insertAtBottom(stack, value);
        }
    }

    public static void insertAtBottom(ArrayDeque<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.offerLast(value);
        } else {
            int val = stack.pollLast();
            insertAtBottom(stack, value);
            stack.offerLast(val);
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        stack.offerLast(1);
        stack.offerLast(2);
        stack.offerLast(3);
        stack.offerLast(4);

        System.out.println(stack);

        reverse(stack);

        System.out.println(stack);
    }
}