import java.util.ArrayDeque;

public class InfixToPostfix {
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

    private static String infixToPostfix(String infix) {
        int n = infix.length();

        StringBuilder postfix = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < n; i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.offer(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    postfix.append(stack.pollLast());
                }
                stack.pollLast();
            } else {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peekLast())) {
                    postfix.append(stack.pollLast());
                }
                stack.offer(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pollLast());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "(p+q)*(m-n)";

        System.out.println(infixToPostfix(infix));
    }
}
