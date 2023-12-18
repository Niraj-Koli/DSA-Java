/*
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            minHeap.offer(key);

            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = k - 1;

        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int[] answer = topKFrequent(nums, k);

        System.out.println(Arrays.toString(answer));
    }
}

// class Solution {
// public int[] topKFrequent(int[] nums, int k) {
// int[] bucket = new int[200001];

// for (int i = 0; i < nums.length; i++) {
// bucket[nums[i] + 100000]++;
// }

// PriorityQueue<Integer> queue = new PriorityQueue<>();

// for (int i = 0; i < bucket.length; i++) {
// if (bucket[i] == 0) {
// continue;
// }
// if (queue.size() == 0) {
// queue.add(bucket[i]);
// } else {
// if (queue.size() < k) {
// queue.add(bucket[i]);
// } else {
// if (bucket[i] > queue.peek()) {
// queue.remove();
// queue.add(bucket[i]);
// }
// }
// }
// }

// Set<Integer> allowedCnts = new HashSet<>(queue);

// int[] result = new int[k];
// int kIndex = 0;
// for (int i = 0; i < bucket.length; i++) {
// if (allowedCnts.contains(bucket[i])) {
// result[kIndex] = i - 100000;
// kIndex++;
// }

// }
// return result;

// }
// }