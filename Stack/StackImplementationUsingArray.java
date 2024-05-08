/*
 * Write a program to implement a Stack using Array. Your task is to use the
 * class as shown in the comments in the code editor and complete the functions
 * push() and pop() to implement a stack.
 */

class StackImplementationUsingArray {

    // Time -> O(1) //
    // Space -> O(n) //

    private static class Stack {
        private int top;
        private int size;
        private int[] arr;

        public Stack() {
            top = -1;
            size = 1000;
            arr = new int[size];
        }

        public void push(int x) {
            arr[++top] = x;
        }

        public int pop() {
            return arr[top--];
        }

        public int top() {
            return arr[top];
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top + 1 == size;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(7);
        stack.push(21);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
        System.out.println(stack.isFull());
    }
}