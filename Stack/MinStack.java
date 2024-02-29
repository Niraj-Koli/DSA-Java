/*
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */

class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
    }
}

// public class MinStack {
// private ArrayDeque<Integer> stack;
// private int minElement;

// public MinStack() {
// stack = new ArrayDeque<Integer>();
// minElement = -1;
// }

// public void push(int val) {
// if (stack.isEmpty()) {
// stack.offerLast(val);
// minElement = val;
// } else {
// if (val >= minElement) {
// stack.offerLast(val);
// } else if (val < minElement) {
// stack.offerLast(2 * val - minElement);
// minElement = val;
// }
// }
// }

// public void pop() {
// if (stack.peekLast() >= minElement) {
// stack.pollLast();
// } else if (stack.peekLast() < minElement) {
// minElement = (2 * minElement) - stack.peekLast();
// stack.pollLast();
// }
// }

// public int top() {
// if (stack.peekLast() >= minElement) {
// return stack.peekLast();
// } else if (stack.peekLast() < minElement) {
// return minElement;
// } else {
// return -1;
// }
// }

// public int getMin() {
// if (stack.isEmpty()) {
// return -1;
// }

// return minElement;
// }

// public static void main(String[] args) {
// MinStack minStack = new MinStack();

// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);

// System.out.println(minStack.getMin());

// minStack.pop();

// System.out.println(minStack.top());

// System.out.println(minStack.getMin());
// }
// }

// public class MinStack {
// private ArrayDeque<Integer> stack;
// private ArrayDeque<Integer> supStack;

// public MinStack() {
// stack = new ArrayDeque<>();
// supStack = new ArrayDeque<>();
// }

// public void push(int ele) {
// stack.offerLast(ele);

// if (supStack.isEmpty() || supStack.peekLast() >= ele) {
// supStack.offerLast(ele);
// }
// }

// public int pop() {
// if (stack.isEmpty()) {
// return -1;
// }

// int popped = stack.pollLast();

// if (!supStack.isEmpty() && supStack.pollLast() == popped) {
// supStack.pollLast();
// }

// return popped;
// }

// public int getMin() {
// if (supStack.isEmpty()) {
// return -1;
// }

// return supStack.pollLast();
// }

// public static void main(String[] args) {
// MinStack minStack = new MinStack();

// minStack.push(3);
// minStack.push(5);
// System.out.println("Minimum Element: " + minStack.getMin());

// minStack.push(2);
// minStack.push(1);
// System.out.println("Minimum Element: " + minStack.getMin());

// minStack.pop();
// System.out.println("Minimum Element: " + minStack.getMin());
// }
// }
