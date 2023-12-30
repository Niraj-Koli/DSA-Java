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
import java.util.List;

public class NQueens {
    public static List<String> construct(char[][] board) {
        int n = board.length;

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void solve(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,
            List<List<String>> result) {
        int n = board.length;

        if (col == n) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, result);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 4;

        List<List<String>> answer = solveNQueens(n);

        System.out.println(answer);
    }
}

// class Solution {
// int m_size;

// public List<List<String>> solveNQueens(int n) {
// List<List<String>> result = new ArrayList<>();

// this.m_size = n;
// char[][] matrix = new char[n][n];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// matrix[i][j] = '.';
// }
// }
// backtracking(matrix, 0, 0, 0, result);
// return result;
// }

// private void backtracking(char[][] matrix,
// int line,
// int col,
// int curr_n,
// List<List<String>> result) {
// if (curr_n == m_size) {
// List<String> temp = new ArrayList<>(m_size);
// for (int i = 0; i < m_size; i++) {
// String str = "";
// for (int j = 0; j < m_size; j++) {
// str += String.valueOf(matrix[i][j]);
// }
// temp.add(str);
// }
// result.add(temp);
// return;
// }
// for (int i = line; i < m_size; i++) {
// for (int j = col; j < m_size; j++) {
// if (isSafeZone(matrix, i, j)) {
// matrix[i][j] = 'Q';
// backtracking(matrix, i, j, curr_n + 1, result);
// matrix[i][j] = '.';
// }
// }
// col = 0;
// }
// }

// private boolean isSafeZone(char[][] matrix, int line, int col) {
// for (int i = 0; i <= line; i++) {
// if (matrix[i][col] == 'Q')
// return false;
// }
// for (int j = 0; j <= col; j++) {
// if (matrix[line][j] == 'Q')
// return false;
// }
// for (int i = line - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
// if (matrix[i][j] == 'Q')
// return false;
// }
// for (int i = line - 1, j = col + 1; i >= 0 && j < m_size; i--, j++) {
// if (matrix[i][j] == 'Q')
// return false;
// }
// return true;
// }
// }