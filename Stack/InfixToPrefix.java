import java.util.ArrayDeque;

public class InfixToPrefix {
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static String infixToPrefix(String infix) {
        int n = infix.length();

        StringBuilder reversedInfix = new StringBuilder(infix).reverse();

        StringBuilder prefix = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < n; i++) {
            char ch = reversedInfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                prefix.append(ch);
            } else if (ch == ')') {
                stack.offer(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peekLast() != ')') {
                    prefix.append(stack.pollLast());
                }
                stack.pollLast();
            } else {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peekLast())) {
                    prefix.append(stack.pollLast());
                }
                stack.offer(ch);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pollLast());
        }

        return prefix.reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "(p+q)*(m-n)";

        System.out.println(infixToPrefix(infix));
    }
}
