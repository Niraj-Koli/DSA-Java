/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 */

import java.util.ArrayList;
import java.util.Arrays;

class MergeIntervals {

    // Time -> O((n * log(n)) + (n)) //
    // Space -> O(n) //

    private static int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<int[]>();

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                mergedIntervals.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }

        mergedIntervals.add(new int[] { start, end });

        return mergedIntervals.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 },
        };

        int[][] ans = merge(intervals);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}