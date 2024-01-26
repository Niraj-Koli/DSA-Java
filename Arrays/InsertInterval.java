/*
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 */

import java.util.ArrayList;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        ArrayList<int[]> res = new ArrayList<int[]>();

        int i = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while (i < n && intervals[i][1] < newStart) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        res.add(new int[] { newStart, newEnd });

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 }, { 3, 5 }, { 6, 7 },
                { 8, 10 }, { 12, 16 }
        };

        int[] newInterval = { 4, 8 };

        int[][] ans = insert(intervals, newInterval);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public int[][] insert(int[][] intervals, int[] newInterval) {
// List<int[]> arr = new ArrayList<>();
// int i = 0;
// while (i < intervals.length && intervals[i][1] < newInterval[0]) {
// arr.add(intervals[i]);
// i++;
// }
// while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
// newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
// newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
// i++;
// }
// arr.add(newInterval);
// while (i < intervals.length && intervals[i][0] > newInterval[1]) {
// arr.add(intervals[i]);
// i++;
// }
// int[][] result = new int[arr.size()][2];
// for (int j = 0; j < result.length; j++) {
// result[j] = arr.get(j);
// }
// return result;
// }
// }