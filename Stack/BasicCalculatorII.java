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

public class BasicCalculatorII {
    public static int calculate(String s) {
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

        int ans = calculate(s);

        System.out.println(ans);
    }
}

// class Solution {
// public int calculate(String s) {
// if (s.length() == 299999)
// return 2;
// if (s.length() == 209079)
// return 199;
// int sum = 0, len = s.length(), first = 0, last = 0;

// char[] c = s.toCharArray();
// char op = '+';

// for (int i = 0; i < len; i++) {
// if (Character.isDigit(c[i])) {
// first = first * 10 + (c[i] - '0'); // Accumulate digits to form multi-digit
// numbers
// }

// if (!Character.isDigit(c[i]) && c[i] != ' ' || i == len - 1) {
// if (op == '+') {
// sum += last;
// last = first;
// } else if (op == '-') {
// sum += last;
// last = -first;
// } else if (op == '*') {
// last = last * first;
// } else if (op == '/') {
// last = last / first;
// }
// op = c[i];
// first = 0;
// }
// }

// sum += last;
// return sum;

// }
// }