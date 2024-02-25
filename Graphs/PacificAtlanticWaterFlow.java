/*
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * 
 * The island is partitioned into a grid of square cells. You are given an m x n
 * integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 * 
 * The island receives a lot of rain, and the rain water can flow to neighboring
 * cells directly north, south, east, and west if the neighboring cell's height
 * is less than or equal to the current cell's height. Water can flow from any
 * cell adjacent to an ocean into the ocean.
 * 
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
 * Atlantic oceans.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void bfs(int[][] heights, ArrayDeque<int[]> queue, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                boolean bounds = ((x >= 0) && (x < n) && (y >= 0) && (y < m));

                if (bounds && !visited[x][y] && heights[x][y] >= heights[current[0]][current[1]]) {
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        ArrayDeque<int[]> pacificQueue = new ArrayDeque<int[]>();
        ArrayDeque<int[]> atlanticQueue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            pacificQueue.offer(new int[] { i, 0 });
            atlanticQueue.offer(new int[] { i, m - 1 });

            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[] { 0, i });
            atlanticQueue.offer(new int[] { n - 1, i });

            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };

        List<List<Integer>> ans = pacificAtlantic(heights);

        System.out.println(ans);
    }
}

// class Solution {
// List<int[]> DIRECTION = new ArrayList<>(
// Arrays.asList(new int[] { 1, 0 }, new int[] { 0, 1 }, new int[] { -1, 0 },
// new int[] { 0, -1 }));
// int m;
// int n;

// public List<List<Integer>> pacificAtlantic(int[][] heights) {
// m = heights.length;
// n = heights[0].length;
// boolean[][] pacific = new boolean[m][n];
// boolean[][] atlantic = new boolean[m][n];
// List<List<Integer>> list = new ArrayList<>();

// for (int row = 0; row < m; row++) {
// pacific[row][0] = true;
// dfs(row, 0, heights, pacific);
// }

// for (int col = 0; col < n; col++) {
// pacific[0][col] = true;
// dfs(0, col, heights, pacific);
// }

// for (int row = 0; row < m; row++) {
// atlantic[row][n - 1] = true;
// dfs(row, n - 1, heights, atlantic);
// }

// for (int col = 0; col < n; col++) {
// atlantic[m - 1][col] = true;
// dfs(m - 1, col, heights, atlantic);
// }

// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (pacific[i][j] && atlantic[i][j]) {
// list.add(new ArrayList<>(Arrays.asList(i, j)));
// }
// }
// }
// return list;
// }

// void dfs(int row, int col, int[][] heights, boolean[][] seen) {
// for (int[] direction : DIRECTION) {
// int r = row + direction[0];
// int c = col + direction[1];
// if (r >= 0 && r < m && c >= 0 && c < n && heights[row][col] <= heights[r][c]
// && !seen[r][c]) {
// seen[r][c] = true;
// dfs(r, c, heights, seen);
// }
// }
// }
// }