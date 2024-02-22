/*
 * Given start, end and an array arr of n numbers. At each step, start is
 * multiplied with any number in the array and then mod operation with 100000 is
 * done to get the new start.
 * 
 * Your task is to find the minimum steps in which end can be achieved starting
 * from start. If it is not possible to reach end, then return -1.
 */

// Time -> O(100000 * N)
// Space -> O(100000 * N)

import java.util.ArrayDeque;

public class MinimumMultiplicationToReachEnd {
    private static class Pair {
        int node;
        int steps;

        Pair(int node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        int mod = 100000;

        if (start == end) {
            return 0;
        }

        int[] dist = new int[mod];

        for (int i = 0; i < mod; i++) {
            dist[i] = (int) (1e9);
        }

        dist[start] = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int node = pair.node;
            int steps = pair.steps;

            for (int i = 0; i < n; i++) {
                int value = (arr[i] * node) % mod;

                if (steps + 1 < dist[value]) {
                    dist[value] = steps + 1;

                    if (value == end) {
                        return steps + 1;
                    }

                    queue.offer(new Pair(value, steps + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7 };
        int start = 3;
        int end = 30;

        int ans = minimumMultiplications(arr, start, end);

        System.out.println(ans);
    }
}