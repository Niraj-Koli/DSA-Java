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

public class KClosestPointsToOrigin {
    public static int compare(int[] a, int[] b) {
        return ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) - (b[1] * b[1]));
    }

    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> compare(b, a));

        for (int i = 0; i < n; i++) {
            maxHeap.offer(points[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;

        while (maxHeap.size() > 0) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        int[][] answer = kClosest(points, k);

        for (int[] a1 : answer) {
            for (int a2 : a1) {
                System.out.print(a2 + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public int[][] kClosest(int[][] points, int k) {
// int lo = 0, hi = points.length - 1;
// while (lo < k) {
// int pivot = partition(points, lo, hi);
// if (pivot == k)
// break;
// else if (pivot < k) {
// lo = pivot;
// } else {
// hi = pivot - 1;
// }
// }
// return Arrays.copyOfRange(points, 0, k);
// }

// public int partition(int[][] points, int lo, int hi) {
// int[] point = points[(hi - lo) / 2 + lo];
// while (lo <= hi) {
// while (lo <= hi && dif(points[lo]) < dif(point))
// lo++;
// while (lo <= hi && dif(point) < dif(points[hi]))
// hi--;
// if (lo <= hi) {
// int[] temp = points[lo];
// points[lo] = points[hi];
// points[hi] = temp;
// lo++;
// hi--;
// }
// }
// return lo;
// }

// public int dif(int[] point) {
// return point[0] * point[0] + point[1] * point[1];
// }
// }