/*
 * Given an array of integers nums, sort the array in increasing order based on
 * the frequency of the values. If multiple values have the same frequency, sort
 * them in decreasing order.
 * 
 * Return the sorted array.
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {
    public static int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int[] result = new int[n];
        int index = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                (a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            maxHeap.offer(key);
        }

        while (!maxHeap.isEmpty()) {
            int freq = map.get(maxHeap.peek());

            for (int i = 0; i < freq; i++) {
                result[index++] = maxHeap.peek();
            }
            maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 3, 2 };

        int[] answer = frequencySort(nums);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// class Solution {
// public int[] frequencySort(int[] nums) {
// Map<Integer, Integer> map = new HashMap<>();

// for (int i : nums) {
// map.put(i, map.getOrDefault(i, 0) + 1);
// }

// System.gc();
// return Arrays.stream(nums).boxed()
// .sorted((a, b) -> map.get(a) == map.get(b) ? (b - a) : map.get(a) -
// map.get(b)).mapToInt(n -> n)
// .toArray();

// }
// }