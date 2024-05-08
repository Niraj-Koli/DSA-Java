/*
 * Given an array of integers nums, sort the array in increasing order based on
 * the frequency of the values. If multiple values have the same frequency, sort
 * them in decreasing order.
 * 
 * Return the sorted array.
 */

import java.util.HashMap;
import java.util.PriorityQueue;

class FrequencySort {

    // Time -> O((n * log(k)) + n) //
    // Space -> O(k) //

    private static int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[n];
        int index = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                (a, b) -> map.get(a) == map.get(b) ? Integer.compare(b, a) : Integer.compare(map.get(a), map.get(b)));

        for (int key : map.keySet()) {
            maxHeap.offer(key);
        }

        while (!maxHeap.isEmpty()) {
            int freq = map.get(maxHeap.peek());

            for (int i = 0; i < freq; i++) {
                res[index++] = maxHeap.peek();
            }
            maxHeap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 3, 2 };

        int[] ans = frequencySort(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}