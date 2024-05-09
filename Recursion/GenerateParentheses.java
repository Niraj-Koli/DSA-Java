/*
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */

import java.util.ArrayList;

class GenerateParentheses {

    // Time -> O(2^n) //
    // Space -> O(n^2) //

    private static void generateBalancedParenthesis(int open, int close, String output, ArrayList<String> res) {
        if (open == 0 && close == 0) {
            res.add(output);
            return;
        }

        if (open != 0) {
            generateBalancedParenthesis(open - 1, close, output + "(", res);
        }

        if (close > open) {
            generateBalancedParenthesis(open, close - 1, output + ")", res);
        }
    }

    private static ArrayList<String> generateParenthesis(int n) {
        int open = n;
        int close = n;

        String output = "";

        ArrayList<String> res = new ArrayList<String>();

        generateBalancedParenthesis(open, close, output, res);

        return res;
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));
    }
}