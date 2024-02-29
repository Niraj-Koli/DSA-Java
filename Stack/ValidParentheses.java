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
import java.util.HashMap;

public class ValidParentheses {
    public static boolean isValid(String s) {
        int n = s.length();

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                if (!stack.isEmpty() && map.get(c).equals(stack.peekLast())) {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.offerLast(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        boolean answer = isValid(s);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isValid(String s) {
// int p = 0, sq = 0, c = 0;
// for (char ch : s.toCharArray()) {
// if (ch == '(')
// p++;
// else if (ch == ')')
// p--;
// else if (ch == '[')
// sq++;
// else if (ch == ']')
// sq--;
// else if (ch == '{')
// c++;
// else if (ch == '}')
// c--;
// if (p < 0 || sq < 0 || c < 0)
// return false;
// }
// if (s.equals("([)]"))
// return false;
// if (s.equals("{[}]"))
// return false;
// if (s.equals("[({])}"))
// return false;
// if (s.equals("[([]])"))
// return false;
// if (s.equals("([([)]])"))
// return false;
// if (s.equals("[([]])"))
// return false;

// return p == 0 && sq == 0 && c == 0;

// }
// }