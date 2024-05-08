/*
 * Given a string s containing only three types of characters: '(', ')' and '*',
 * return true if s is valid.
 * 
 * The following rules define a valid string:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string "".
 */

class ValidParenthesisString {

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean checkValidString(String s) {
        int n = s.length();

        int opened = 0;
        int unbalanced = 0;

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                unbalanced++;
                opened++;
            } else if (c == ')') {
                unbalanced--;
                opened = Math.max(opened - 1, 0);
            } else {
                unbalanced++;
                opened = Math.max(opened - 1, 0);
            }

            if (unbalanced < 0) {
                return false;
            }
        }

        return opened == 0;
    }

    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        System.out.println(checkValidString(s));
    }
}