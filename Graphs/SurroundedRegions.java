/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 */

// Time -> O(N x M)
// Space -> O(N x M)

public class SurroundedRegions {
    public static void dfs(int row, int col, boolean[][] vis, char[][] board, int[] dx, int[] dy) {
        int n = board.length;
        int m = board[0].length;

        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

            if (bounds && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, dx, dy);
            }
        }
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, vis, board, dx, dy);
            }

            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, dx, dy);
            }
        }

        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, vis, board, dx, dy);
            }

            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, dx, dy);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        solve(board);

        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// int n, m;
// char[][] arr;

// public void solve(char[][] board) {
// n = board.length;
// m = board[0].length;
// arr = board;
// for (int i = 0; i < m; i++) {
// if (arr[0][i] == 'O')
// mark(0, i);
// if (arr[n - 1][i] == 'O')
// mark(n - 1, i);
// }
// for (int i = 0; i < n; i++) {
// if (arr[i][0] == 'O')
// mark(i, 0);
// if (arr[i][m - 1] == 'O')
// mark(i, m - 1);
// }
// for (int i = 0; i < n; i++) {
// mass(arr[i]);
// }
// }

// void mass(char[] grid) {
// for (int i = 0; i < m; i++) {
// if (grid[i] == 'O')
// grid[i] = 'X';
// if (grid[i] == '*')
// grid[i] = 'O';
// }
// }

// void mark(int i, int j) {
// arr[i][j] = '*';
// if (i > 0 && arr[i - 1][j] == 'O')
// mark(i - 1, j);
// if (i < n - 1 && arr[i + 1][j] == 'O')
// mark(i + 1, j);
// if (j > 0 && arr[i][j - 1] == 'O')
// mark(i, j - 1);
// if (j < m - 1 && arr[i][j + 1] == 'O')
// mark(i, j + 1);
// }
// }