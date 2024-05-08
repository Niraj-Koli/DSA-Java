/*
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 */

import java.util.ArrayDeque;

class RemoveKDigits {

    // Time -> O(n) //
    // Space -> O(n) //

    private static String removeKdigits(String num, int k) {
        int n = num.length();

        if (n == k) {
            return "0";
        }

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offer(digit);
        }

        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder res = new StringBuilder();
        
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }

        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }
}