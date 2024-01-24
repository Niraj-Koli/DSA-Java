/*
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the res of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 */

import java.util.ArrayDeque;

public class BasicCalculator {
    public static int calculate(String s) {
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
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();

            }
        }

        if (number != 0) {
            res += sign * number;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";

        int ans = calculate(s);

        System.out.println(ans);
    }
}

// class Solution {
// private int INDEX;

// public int calculate(String s) {
// INDEX = 0;
// return calc(s.toCharArray());
// }

// private int calc(char[] sarray) {
// int sum = 0;
// int nextSign = 1;
// while (INDEX < sarray.length) {
// switch (sarray[INDEX]) {
// case ' ' -> {
// }
// case '+' -> nextSign = 1;
// case '-' -> nextSign = -1;
// case '(' -> {
// INDEX++;
// sum += (nextSign * calc(sarray));
// }
// case ')' -> {
// return sum;
// }
// default -> {
// int number = sarray[INDEX] - '0';
// while (INDEX + 1 < sarray.length && sarray[INDEX + 1] >= '0') {
// INDEX++;
// number = number * 10 + (sarray[INDEX] - '0');
// }
// sum += (nextSign * number);
// }
// }
// INDEX++;
// }
// return sum;
// }
// }