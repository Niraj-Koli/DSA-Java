/*
 * Design your implementation of the circular queue. The circular queue is a
 * linear data structure in which the operations are performed based on FIFO
 * (First In First Out) principle, and the last position is connected back to
 * the first position to make a circle. It is also called "Ring Buffer".
 * 
 * One of the benefits of the circular queue is that we can make use of the
 * spaces in front of the queue. In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the
 * queue. But using the circular queue, we can use the space to store new
 * values.
 * 
 * Implement the MyCircularQueue class:
 * 
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return
 * -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return
 * -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return
 * true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if
 * the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 * You must solve the problem without using the built-in queue data structure in
 * your programming language.
 */

import java.util.Arrays;

class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int total;

    public MyCircularQueue(int k) {
        queue = new int[k];
        Arrays.fill(queue, -1);
        front = 0;
        rear = 0;
        size = k;
        total = 0;
    }

    public boolean enQueue(int value) {
        if (total < size) {
            queue[rear % size] = value;
            rear++;
            total++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (queue[front % size] != -1) {
            queue[front % size] = -1;
            front++;
            total--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front % size];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == size;
    }
}

public class DesignCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}

// class MyCircularQueue {
// private final int k;
// private final int[] array;
// private int front;
// private int back;
// private int size;

// public MyCircularQueue(int k) {
// this.k = k;
// this.array = new int[k];
// this.front = 0;
// this.back = k - 1;
// this.size = 0;
// }

// public boolean enQueue(int value) {
// if (isFull()) {
// return false;
// }
// back = (back + 1) % k;
// array[back] = value;
// size++;
// return true;
// }

// public boolean deQueue() {
// if (isEmpty()) {
// return false;
// }
// front = (front + 1) % k;
// size--;
// return true;
// }

// public int Front() {
// if (isEmpty()) {
// return -1;
// }
// return array[front];
// }

// public int Rear() {
// if (isEmpty()) {
// return -1;
// }
// return array[back];
// }

// public boolean isEmpty() {
// return size == 0;
// }

// public boolean isFull() {
// return size == array.length;
// }
// }
