/*
 * There are given N ropes of different lengths, we need to connect these ropes
 * into one rope. The cost to connect two ropes is equal to sum of their
 * lengths.
 * The task is to connect the ropes with minimum cost. Given N size array arr[]
 * contains the lengths of the ropes.
 */

import java.util.PriorityQueue;

class MinimumCostOfRopes {

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static long minCost(long[] nums) {
        long cost = 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();

        for (long num : nums) {
            minHeap.offer(num);
        }

        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();

            cost += (first + second);

            minHeap.offer((first + second));
        }

        return cost;
    }

    public static void main(String[] args) {
        long[] nums = { 4, 3, 2, 6 };

        System.out.println(minCost(nums));
    }
}