/*
 * Implement a first in first out (FIFO) queue using only two stacks. The
 * implemented queue should support all the functions of a normal queue (push,
 * peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 * 
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * 
 * You must use only standard operations of a stack, which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may
 * simulate a stack using a list or deque (double-ended queue) as long as you
 * use only a stack's standard operations.
 */

import java.util.ArrayDeque;

public class QueueImplementationUsingStacks {
    ArrayDeque<Integer> input;
    ArrayDeque<Integer> output;

    public QueueImplementationUsingStacks() {
        input = new ArrayDeque<Integer>();
        output = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        input.offer(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.offer(input.pollLast());
            }
        }
        return output.pollLast();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.offer(input.pollLast());
            }
        }
        return output.peekLast();
    }

    public int size() {
        return (output.size() + input.size());
    }

    public boolean empty() {
        return (output.isEmpty() && input.isEmpty());
    }

    public static void main(String[] args) {
        QueueImplementationUsingStacks queue = new QueueImplementationUsingStacks();

        queue.push(10);
        queue.push(7);
        queue.push(21);

        System.out.println(queue.size());

        System.out.println(queue.empty());

        System.out.println(queue.peek());

        System.out.println(queue.pop());

        System.out.println(queue.peek());
    }
}

// class MyQueue {

// Stack<Integer> stack1 = new Stack<>();
// Stack<Integer> stack2 = new Stack<>();

// public MyQueue() {

// }

// public void push(int x) {
// while (!stack1.isEmpty()) {
// stack2.push(stack1.pop());
// }
// stack1.push(x);

// while (!stack2.isEmpty()) {
// stack1.push(stack2.pop());
// }
// }

// public int pop() {
// return stack1.pop();
// }

// public int peek() {
// return stack1.peek();
// }

// public boolean empty() {
// return stack1.isEmpty();
// }
// }
