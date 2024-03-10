/*
 * You are given ‘q’ queries, where each query can be of the following types:
 * 
 * (1) 1 x -> this means to push the element ‘x’ in the queue.
 * (2) 2 -> This means deleting the front element of the queue and returning it.
 * If there’s no element in the queue, return -1.
 * Your task is to implement a queue that supports these two queries.
 * 
 * You must write an algorithm whose time complexity is O(1), and whose space
 * complexity is O(1).
 */

public class QueueImplementationUsingLinkedList {

    // Time -> O(1) //
    // Space -> O(n) //

    private static class Queue {
        private class ListNode {
            int data;
            ListNode next;

            public ListNode(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private ListNode front;
        private ListNode rear;
        private int size;

        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }

        public void enqueue(int value) {
            ListNode temp = new ListNode(value);

            if (front == null) {
                front = temp;
                rear = temp;
            } else {
                rear.next = temp;
                rear = temp;
            }
            size++;
        }

        public void dequeue() {
            front = front.next;
            size--;
        }

        public int peek() {
            return front.data;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println(queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(7);
        queue.enqueue(21);

        System.out.println(queue.peek());
        System.out.println(queue.getSize());
        queue.dequeue();
        System.out.println(queue.peek());
    }
}