/*
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 */

// Time -> O(N x M)
// Space -> O(N x M)

import java.util.ArrayDeque;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        int totalOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }

                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        if (totalOranges == 0) {
            return 0;
        }

        int rottenOranges = 0;
        int minutes = 0;

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenOranges += size;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.offer(new int[] { x, y });
                }
            }
            if (!queue.isEmpty()) {
                minutes++;
            }
        }
        return totalOranges == rottenOranges ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        int answer = orangesRotting(grid);

        System.out.println(answer);
    }
}

// class Solution {
// int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
// int n = 0, m = 0;

// public int orangesRotting(int[][] grid) {
// Queue<int[]> q = new LinkedList<>();

// n = grid.length;
// m = grid[0].length;
// int cnt = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (grid[i][j] == 2) {
// q.add(new int[] { i, j });
// } else if (grid[i][j] == 1)
// cnt++;
// }
// }

// int res = 0;
// // boolean[][]
// while (!q.isEmpty()) {
// int size = q.size();
// for (int i = 0; i < size; i++) {
// int[] cur = q.poll();
// // System.out.println(Arrays.toString(cur));

// if (grid[cur[0]][cur[1]] == 1)
// cnt--;

// grid[cur[0]][cur[1]] = -1;

// if (cnt == 0)
// return res;

// for (int[] dir : dirs) {
// int newx = cur[0] + dir[0];
// int newy = cur[1] + dir[1];

// if (notValid(newx, newy) || grid[newx][newy] != 1)
// continue;

// // System.out.println("val1 => "+newx +" val2 => "+newy);

// // if(grid[])
// q.add(new int[] { newx, newy });
// }
// }
// // return 0;
// res++;

// }
// return cnt == 0 ? res : -1;
// }

// boolean notValid(int i, int j) {
// return i < 0 || j < 0 || i >= n || j >= m;
// }
// }