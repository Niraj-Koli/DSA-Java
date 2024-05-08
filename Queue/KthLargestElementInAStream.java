/*
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the
 * element representing the kth largest element in the stream.
 */

import java.util.PriorityQueue;

// Time -> O(n * log(k)) //
// Space -> O(k) //

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int kth;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        kth = k;

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > kth) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}