/*
 * A boolean expression is an expression that evaluates to either true or false.
 * It can be in one of the following shapes:
 * 
 * 't' that evaluates to true.
 * 'f' that evaluates to false.
 * '!(subExpr)' that evaluates to the logical NOT of the inner expression
 * subExpr.
 * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of
 * the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of
 * the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * Given a string expression that represents a boolean expression, return the
 * evaluation of that expression.
 * 
 * It is guaranteed that the given expression is valid and follows the given
 * rules.
 */

import java.util.ArrayDeque;
import java.util.HashSet;

class ParsingABooleanExpression {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean parseBoolExpr(String expression) {
        int n = expression.length();

        ArrayDeque<Character> deque = new ArrayDeque<Character>();

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);

            if (ch == ')') {
                HashSet<Character> seen = new HashSet<Character>();

                while (deque.peekFirst() != '(') {
                    seen.add(deque.pollFirst());
                }

                deque.pollFirst();

                char operator = deque.pollFirst();

                if (operator == '&') {
                    deque.offerFirst(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    deque.offerFirst(seen.contains('t') ? 't' : 'f');
                } else {
                    deque.offerFirst(seen.contains('t') ? 'f' : 't');
                }
            } else if (ch != ',') {
                deque.offerFirst(ch);
            }
        }

        return deque.pollFirst() == 't';
    }

    public static void main(String[] args) {
        String expression = "!(&(f,t))";

        System.out.println(parseBoolExpr(expression));
    }
}