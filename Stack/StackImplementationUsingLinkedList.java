/*
 * You must implement the Stack data structure using a Singly Linked List.
 * 
 * Create a class named 'Stack' which supports the following operations(all in
 * O(1) time):
 * 
 * getSize: Returns an integer. Gets the current size of the stack
 * 
 * isEmpty: Returns a boolean. Gets whether the stack is empty
 * 
 * push: Returns nothing. Accepts an integer. Puts that integer at the top of
 * the stack
 * 
 * pop: Returns nothing. Removes the top element of the stack. It does nothing
 * if the stack is empty.
 * 
 * getTop: Returns an integer. Gets the top element of the stack. Returns -1 if
 * the stack is empty
 */

public class StackImplementationUsingLinkedList {

    // Time -> O(1) //
    // Space -> O(n) //

    private static class Stack {
        private class ListNode {
            int data;
            ListNode next;

            public ListNode(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private ListNode top;
        private int size;

        public Stack() {
            top = null;
            size = 0;
        }

        public void push(int data) {
            ListNode node = new ListNode(data);
            node.next = top;
            top = node;
            size++;
        }

        public int pop() {
            int topData = top.data;
            top = top.next;
            size--;
            return topData;
        }

        public int peek() {
            return top.data;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(7);
        stack.push(21);

        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}