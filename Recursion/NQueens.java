/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You
 * may return the answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 */

import java.util.ArrayList;

class NQueens {

    // Time -> O(n!) //
    // Space -> O(n) //

    private static ArrayList<String> construct(char[][] board) {
        int n = board.length;

        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }

    private static void solve(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,
            ArrayList<ArrayList<String>> res) {
        int n = board.length;

        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, res);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    private static ArrayList<ArrayList<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, res);

        return res;
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(solveNQueens(n));
    }
}