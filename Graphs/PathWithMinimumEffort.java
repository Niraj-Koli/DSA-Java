/*
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 */

// Time -> O(E Log(V)) + O(N x M) + O(Log(N x M))
// Space -> O(N x M)

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private static class Tuple {
        int distance;
        int row;
        int col;

        Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);
        pq.offer(new Tuple(0, 0, 0));

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();

            int diff = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newrow = row + dx[i];
                int newcol = col + dy[i];

                boolean bounds = (newrow >= 0 && newrow < n) && (newcol >= 0 && newcol < m);

                if (bounds) {
                    int curEffort = Math.abs(heights[row][col] - heights[newrow][newcol]);
                    int newEffort = Math.max(diff, curEffort);

                    if (newEffort < dist[newrow][newcol]) {
                        dist[newrow][newcol] = newEffort;
                        pq.offer(new Tuple(newEffort, newrow, newcol));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };

        int ans = minimumEffortPath(heights);

        System.out.println(ans);
    }
}

// class Solution {
// boolean[][] visited;

// public int minimumEffortPath(int[][] heights) {
// int m = heights.length;
// int n = heights[0].length;
// int l = 0;
// int r = 999998;
// while (l <= r) {
// visited = new boolean[m][n];
// int mid = (l + r) >> 1;
// if (helper(heights, 0, 0, mid)) {
// r = mid - 1;
// } else {
// l = mid + 1;
// }
// }

// return l;
// }

// public boolean helper(int[][] heights, int x, int y, int mid) {
// int m = heights.length;
// int n = heights[0].length;
// visited[x][y] = true;

// if (x == m - 1 && y == n - 1) {
// return true;
// }

// int t = x + 1;
// if (t < m && !visited[t][y]) {
// if (Math.abs(heights[x][y] - heights[t][y]) <= mid) {
// if (helper(heights, t, y, mid)) {
// return true;
// }
// }
// }

// t = y + 1;
// if (t < n && !visited[x][t]) {
// if (Math.abs(heights[x][y] - heights[x][t]) <= mid) {
// if (helper(heights, x, t, mid)) {
// return true;
// }
// }
// }

// t = x - 1;
// if (t >= 0 && !visited[t][y]) {
// if (Math.abs(heights[x][y] - heights[t][y]) <= mid) {
// if (helper(heights, t, y, mid)) {
// return true;
// }
// }
// }

// t = y - 1;
// if (t >= 0 && !visited[x][t]) {
// if (Math.abs(heights[x][y] - heights[x][t]) <= mid) {
// if (helper(heights, x, t, mid)) {
// return true;
// }
// }
// }

// return false;
// }
// }