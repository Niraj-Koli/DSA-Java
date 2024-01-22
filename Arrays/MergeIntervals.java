/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<int[]>();

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

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

// class Solution {
// public int[][] merge(int[][] intervals) {
// int min = Integer.MAX_VALUE;
// int max = Integer.MIN_VALUE;

// for (int i = 0; i < intervals.length; i++) {
// min = Math.min(min, intervals[i][0]);
// max = Math.max(max, intervals[i][0]);
// }

// int[] range = new int[max - min + 1];
// for (int i = 0; i < intervals.length; i++) {
// range[intervals[i][0] - min] = Math.max(intervals[i][1] - min,
// range[intervals[i][0] - min]);
// }

// int start = 0, end = 0;
// LinkedList<int[]> result = new LinkedList<>();
// for (int i = 0; i < range.length; i++) {
// if (range[i] == 0) {
// continue;
// }
// if (i <= end) {
// end = Math.max(range[i], end);
// } else {
// result.add(new int[] { start + min, end + min });
// start = i;
// end = range[i];
// }
// }
// result.add(new int[] { start + min, end + min });
// return result.toArray(new int[result.size()][]);
// }
// }