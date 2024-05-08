/*
 * There are given n ropes of different lengths, we need to connect these ropes
 * into one rope. The cost to connect two ropes is equal to sum of their
 * lengths. We need to connect the ropes with minimum cost.
 */

import java.util.PriorityQueue;

class ConnectNRopesWithMinimumCost {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int rope : ropes) {
            pq.offer(rope);
        }

        int total = 0;

        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();

            total += cost;

            pq.offer(cost);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] ropes = { 4, 4, 3, 2, 6 };

        System.out.println(minCost(ropes));
    }
}