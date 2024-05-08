/*
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the res of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 */

import java.util.ArrayDeque;

class BasicCalculator {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int calculate(String s) {
        int n = s.length();

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        int res = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.offer(res);
                stack.offer(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pollLast();
                res += stack.pollLast();

            }
        }

        if (number != 0) {
            res += sign * number;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(calculate(s));
    }
}