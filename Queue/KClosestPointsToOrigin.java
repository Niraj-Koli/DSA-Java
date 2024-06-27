/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 */

import java.util.PriorityQueue;

class KClosestPointsToOrigin {
    private static int compare(int[] a, int[] b) {
        return ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1]));
    }

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> compare(b, a));

        for (int i = 0; i < n; i++) {
            maxHeap.offer(points[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            res[index++] = maxHeap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        int[][] ans = kClosest(points, k);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}