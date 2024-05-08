/*
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * 
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * 
 * Note that:
 * 
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish
 * notation.
 * The answer and all the intermediate calculations can be represented in a
 * 32-bit integer.
 */

import java.util.ArrayDeque;

class EvaluateReversePolishNotation {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.offer(stack.pollLast() + stack.pollLast());
            } else if (token.equals("-")) {
                int b = stack.pollLast();
                int a = stack.pollLast();

                stack.offer(a - b);
            } else if (token.equals("*")) {
                stack.offer(stack.pollLast() * stack.pollLast());
            } else if (token.equals("/")) {
                int b = stack.pollLast();
                int a = stack.pollLast();

                stack.offer(a / b);
            } else {
                stack.offer(Integer.valueOf(token));
            }
        }

        return stack.peekLast();
    }

    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

        System.out.println(evalRPN(tokens));
    }
}