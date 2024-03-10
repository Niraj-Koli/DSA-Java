/*
 * You are given an integer array heights representing the heights of buildings,
 * some bricks, and some ladders.
 * 
 * You start your journey from building 0 and move to the next building by
 * possibly using bricks or ladders.
 * 
 * While moving from building i to building i+1 (0-indexed),
 * 
 * If the current building's height is greater than or equal to the next
 * building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you
 * can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building i (0-indexed) you can reach if you use the
 * given ladders and bricks optimally.
 */

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                minHeap.offer(diff);
            }

            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }

        return n - 1;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 12, 2, 7, 3, 18, 20, 3, 19 };
        int bricks = 10;
        int ladders = 2;

        int ans = furthestBuilding(heights, bricks, ladders);

        System.out.println(ans);
    }
}

// class Solution {
// public int furthestBuilding(int[] heights, int bricks, int ladders) {
// int n = heights.length;
// int[] gapArray = new int[n];
// gapArray[0] = 0;
// for (int i = n - 1; i >= 1; i--) {
// int diff = heights[i] - heights[i - 1];
// gapArray[i] = diff <= 0 ? 0 : diff;
// }

// int l = 0;
// int r = n - 1;
// int max_index = 0;
// while (l <= r) {
// int m = (l + r) / 2;
// int[] rangeArray = Arrays.copyOfRange(gapArray, 0, m + 1);

// if (rangeArray.length <= ladders) {
// max_index = Math.max(max_index, m);
// l = m + 1;
// } else {

// elements
// Arrays.sort(rangeArray);
// int sum = 0;

// for (int i = 0; i < rangeArray.length - ladders; i++) {
// sum += rangeArray[i];
// }

// if (sum <= bricks) {
// max_index = Math.max(max_index, m);
// l = m + 1;
// } else {
// r = m - 1;
// }
// }
// }

// return max_index;
// }
// }