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

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.offerLast(stack.pollLast() + stack.pollLast());
            } else if (token.equals("-")) {
                int b = stack.pollLast();
                int a = stack.pollLast();

                stack.offerLast(a - b);
            } else if (token.equals("*")) {
                stack.offerLast(stack.pollLast() * stack.pollLast());
            } else if (token.equals("/")) {
                int b = stack.pollLast();
                int a = stack.pollLast();

                stack.offerLast(a / b);
            } else {
                stack.offerLast(Integer.valueOf(token));
            }
        }

        return stack.peekLast();
    }

    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

        int answer = evalRPN(tokens);

        System.out.println(answer);
    }
}

// class Solution {
// static int i = 0;

// public int evalRPN(String[] tokens) {
// i = tokens.length - 1;
// return calculate(tokens);
// }

// public int calculate(String[] tokens) {
// String token = tokens[i];
// i--;

// switch (token) {
// case "+": {
// int p1 = calculate(tokens);
// int p2 = calculate(tokens);
// return p1 + p2;
// }
// case "-": {
// int p1 = calculate(tokens);
// int p2 = calculate(tokens);
// return p2 - p1;
// }
// case "*": {
// int p1 = calculate(tokens);
// int p2 = calculate(tokens);
// return p1 * p2;
// }
// case "/": {
// int p1 = calculate(tokens);
// int p2 = calculate(tokens);
// return p2 / p1;
// }
// default: {
// return Integer.valueOf(token);
// }
// }
// }
// }