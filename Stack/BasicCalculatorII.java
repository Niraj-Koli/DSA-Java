/*
 * Given a string s which represents an expression, evaluate this expression and
 * return its value.
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-231, 231 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 */

import java.util.ArrayDeque;

class BasicCalculatorII {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int calculate(String s) {
        int n = s.length();

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                if (sign == '+') {
                    stack.offer(num);
                } else if (sign == '-') {
                    stack.offer(-num);
                } else if (sign == '*') {
                    stack.offer(stack.pollLast() * num);
                } else if (sign == '/') {
                    stack.offer(stack.pollLast() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "3+2*2";

        System.out.println(calculate(s));
    }
}