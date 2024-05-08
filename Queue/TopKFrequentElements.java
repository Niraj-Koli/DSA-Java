/*
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */

import java.util.HashMap;
import java.util.PriorityQueue;

class TopKFrequentElements {

    // Time -> O((n * log(k)) + n) //
    // Space -> O(n + k) //

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for (int key : map.keySet()) {
            minHeap.offer(key);

            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = k - 1;

        while (!minHeap.isEmpty()) {
            res[i--] = minHeap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int[] ans = topKFrequent(nums, k);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}