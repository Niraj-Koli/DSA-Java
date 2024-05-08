/*
 * Given two equally sized 1-D arrays A, B containing N integers each.
 * 
 * A sum combination is made by adding one element from array A and another
 * element of array B.
 * 
 * Return the maximum C valid sum combinations from all the possible sum
 * combinations.
 */

import java.util.PriorityQueue;

class MaximumSumCombinations {

    // Time -> O(n^2 * (k *log(n))) //
    // Space -> O(n^2) //

    private static int[] maxCombinations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(nums1[i] + nums2[j]);
            }
        }

        int[] res = new int[n];
        int index = 0;

        while (index < k) {
            res[index++] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 2, 3 };
        int[] nums2 = { 2, 5, 1, 6 };
        int k = 4;

        int[] ans = maxCombinations(nums1, nums2, k);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}