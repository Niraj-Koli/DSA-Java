/*
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 */

import java.util.Arrays;

class NonOverlappingIntervals {

    // Time -> O((n * log(n)) + (n)) //
    // Space -> O(1) //

    private static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

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

        System.out.println(eraseOverlapIntervals(intervals));
    }
}