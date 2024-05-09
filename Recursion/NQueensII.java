/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such tha/t no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 */

class NQueensII {

    // Time -> O(n!) //
    // Space -> O(n) //

    private static int solve(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,
            int res) {
        int n = board.length;

        if (col == n) {
            return 1 + res;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                res = solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, res);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }

        return res;
    }

    private static int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        return solve(0, board, leftRow, lowerDiagonal, upperDiagonal, 0);
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(totalNQueens(n));
    }
}