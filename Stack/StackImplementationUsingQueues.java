/*
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 */

import java.util.ArrayDeque;

public class StackImplementationUsingQueues {
    ArrayDeque<Integer> queue;

    public StackImplementationUsingQueues() {
        queue = new ArrayDeque<Integer>();
    }

    private void push(int x) {
        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    private int pop() {
        return queue.poll();
    }

    private int top() {
        return queue.peek();
    }

    private int size() {
        return queue.size();
    }

    private boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackImplementationUsingQueues stack = new StackImplementationUsingQueues();

        stack.push(10);
        stack.push(7);
        stack.push(21);

        System.out.println(stack.size());

        System.out.println(stack.empty());

        System.out.println(stack.top());

        System.out.println(stack.pop());

        System.out.println(stack.top());
    }
}

// class MyStack {
// Queue<Integer> queue = new ArrayDeque<>();
// Queue<Integer> bufferQueue = new ArrayDeque<>();

// public MyStack() {
// }

// public void push(int x) {
// queue.offer(x);
// }

// public int pop() {
// moveToBuffer();
// int val = queue.poll();
// moveToQueue();
// return val;
// }

// public int top() {
// moveToBuffer();
// int val = queue.peek();
// return val;
// }

// public boolean empty() {
// return queue.isEmpty() && bufferQueue.isEmpty();
// }

// private void moveToBuffer() {
// while (queue.size() > 1) {
// bufferQueue.offer(queue.poll());
// }
// }

// private void moveToQueue() {
// while (!bufferQueue.isEmpty()) {
// queue.offer(bufferQueue.poll());
// }
// }
// }
