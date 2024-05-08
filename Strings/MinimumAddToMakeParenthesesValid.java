/*
 * A parentheses string is valid if and only if:
 * 
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a
 * parenthesis at any position of the string.
 * 
 * For example, if s = "()))", you can insert an opening parenthesis to be
 * "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */

class MinimumAddToMakeParenthesesValid {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int minAddToMakeValid(String s) {
        int n = s.length();

        int res = 0;
        int opened = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                opened++;
            } else if (ch == ')' && opened > 0) {
                opened--;
            } else {
                res++;
            }
        }

        return res + opened;
    }

    public static void main(String[] args) {
        String s = "()))((";

        System.out.println(minAddToMakeValid(s));
    }
}