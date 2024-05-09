/*
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to
 * reach the destination at (N - 1, N - 1). Find all possible paths that the rat
 * can take to reach from source to destination. The directions in which the rat
 * can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell
 * in the matrix represents that it is blocked and rat cannot move to it while
 * value 1 at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be vis more than one time. If the source
 * cell is 0, the rat cannot move to any other cell.
 */

import java.util.ArrayList;

class RatInAMaze {

    // Time -> O(4^(n * m)) //
    // Space -> O(n * m) //

    private static void solve(int[][] maze, int n, int i, int j, String move, int[][] vis,
            ArrayList<String> res) {
        if ((i == n - 1) && (j == n - 1)) {
            res.add(move);
            return;
        }

        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };

        char[] direction = { 'D', 'L', 'R', 'U' };

        for (int k = 0; k < 4; k++) {
            int nexti = i + di[k];
            int nextj = j + dj[k];

            boolean condition = nexti >= 0 && nexti < n && nextj >= 0 && nextj < n && vis[nexti][nextj] == 0
                    && maze[nexti][nextj] == 1;

            if (condition) {
                vis[i][j] = 1;
                solve(maze, n, nexti, nextj, move + direction[k], vis, res);
                vis[i][j] = 0;
            }
        }
    }

    private static ArrayList<String> findPath(int[][] maze, int n) {
        int[][] vis = new int[n][n];

        ArrayList<String> res = new ArrayList<String>();

        if (maze[0][0] == 1) {
            solve(maze, n, 0, 0, "", vis, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        System.out.println(findPath(maze, n));
    }
}