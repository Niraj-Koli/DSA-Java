/*
 * Given an array A[] of N positive integers and two positive integers K1 and
 * K2. Find the sum of all elements between K1th and K2th smallest elements of
 * the array. It may be assumed that (1 <= k1 < k2 <= n).
 */

import java.util.PriorityQueue;

class SumOfElementsBetweenK1thAndK2thSmallestElements {

    // Time -> O(n * log(max(k1, k2))) //
    // Space -> O(max(k1, k2)) //

    private static long KSmallestElement(long[] nums, long k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>((a, b) -> Long.compare(b, a));

        for (long number : nums) {
            maxHeap.offer(number);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    private static long sumBetweenTwoKth(long[] nums, long k1, long k2) {
        int n = nums.length;

        long first = KSmallestElement(nums, k1);
        long second = KSmallestElement(nums, k2);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (first < nums[i] && nums[i] < second) {
                sum += nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        long[] nums = { 20, 8, 22, 4, 12, 10, 14 };
        long k1 = 3;
        long k2 = 6;

        System.out.println(sumBetweenTwoKth(nums, k1, k2));
    }
}