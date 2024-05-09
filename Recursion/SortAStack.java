/* You are given a stack ‘S’. Your task is to sort the stack recursively. */

import java.util.ArrayDeque;

class SortAStack {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static void insert(ArrayDeque<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peekLast() <= element) {
            stack.offer(element);
        } else {
            int temp = stack.pollLast();

            insert(stack, element);
            stack.offer(temp);
        }
    }

    private static void sortStack(ArrayDeque<Integer> stack) {
        if (!stack.isEmpty()) {
            int val = stack.pollLast();

            sortStack(stack);
            insert(stack, val);
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        stack.offer(2);
        stack.offer(1);
        stack.offer(4);
        stack.offer(3);

        System.out.println(stack);

        sortStack(stack);

        System.out.println(stack);
    }
}