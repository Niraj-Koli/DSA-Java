/*
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 */

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int res = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                res++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 }, { 2, 3 }, { 3, 4 },
                { 1, 3 }
        };

        int ans = eraseOverlapIntervals(intervals);

        System.out.println(ans);
    }
}

// class Solution {
// public int eraseOverlapIntervals(int[][] intervals) {
// int max = intervals[0][1];
// int min = max;
// for (int i = 1; i < intervals.length; i++) {
// max = Math.max(max, intervals[i][1]);
// min = Math.min(min, intervals[i][1]);
// }

// int shift = 1 - min;
// int maxIntervalRange = 2 + max - min;
// int[] rightEnds = new int[maxIntervalRange];
// for (int[] interval : intervals) {
// int left = interval[0] + shift;
// int right = interval[1] + shift;
// if (left > rightEnds[right])
// rightEnds[right] = left;
// }

// int start = 1;
// int count = 1;
// for (int i = 2; i < maxIntervalRange; i++) {
// if (start <= rightEnds[i]) {
// count++;
// start = i;
// }
// }

// return intervals.length - count;
// }
// }