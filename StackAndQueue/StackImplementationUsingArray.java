/*
 * Write a program to implement a Stack using Array. Your task is to use the
 * class as shown in the comments in the code editor and complete the functions
 * push() and pop() to implement a stack.
 */

public class StackImplementationUsingArray {
    private int top;
    private int[] arr;

    public StackImplementationUsingArray() {
        top = -1;
        arr = new int[1000];
    }

    private void push(int x) {
        top++;
        arr[top] = x;
    }

    private int pop() {
        return arr[top--];
    }

    private int top() {
        return arr[top];
    }

    private int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackImplementationUsingArray stack = new StackImplementationUsingArray();

        stack.push(10);
        stack.push(7);
        stack.push(21);

        System.out.println(stack.top());

        System.out.println(stack.pop());

        System.out.println(stack.top());

        System.out.println(stack.size());
    }
}