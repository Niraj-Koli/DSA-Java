/*
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * You must find a solution with a memory complexity better than O(n2).
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.offer(matrix[i][j]);

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;

        int answer = kthSmallest(matrix, k);

        System.out.println(answer);
    }
}

// class Solution {
// public int kthSmallest(int[][] matrix, int k) {
// int n = matrix.length;

// int[] helper = new int[n * n];
// int index = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// helper[index] = matrix[i][j];
// index++;
// }
// }

// Arrays.sort(helper);

// return helper[k - 1];
// }
// }