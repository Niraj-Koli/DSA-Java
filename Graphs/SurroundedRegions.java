/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 */

class SurroundedRegions {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static void dfs(int row, int col, boolean[][] vis, char[][] board, int[] dx, int[] dy) {
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

    private static void solve(char[][] board) {
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