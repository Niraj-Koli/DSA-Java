/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

import java.util.ArrayDeque;

class ValidParentheses {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.offer(')');
            } else if (ch == '[') {
                stack.offer(']');
            } else if (ch == '{') {
                stack.offer('}');
            } else if (stack.isEmpty() || stack.pollLast() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
}