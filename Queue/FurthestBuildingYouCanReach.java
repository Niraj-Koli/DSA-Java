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

class FurthestBuildingYouCanReach {

    // Time -> O(n * log(ladders)) //
    // Space -> O(ladders) //

    private static int furthestBuilding(int[] heights, int bricks, int ladders) {
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

        System.out.println(furthestBuilding(heights, bricks, ladders));
    }
}