/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such tha/t no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 */

public class NQueensII {
    public static int solve(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,
            int result) {
        int n = board.length;

        if (col == n) {
            return 1 + result;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                result = solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, result);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }

        return result;
    }

    public static int totalNQueens(int n) {
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

        int answer = totalNQueens(n);

        System.out.println(answer);
    }
}

// class Solution {
// public int totalNQueens(int num) {
// int[] memo = new int[num];
// int count = 0;
// for (int i = 0; i < num; i++) {
// memo[0] = i;
// count = count + dfs(0, i, memo, num);
// }
// return count;
// }

// public static int dfs(int x, int y, int[] memo, int num) {
// int count = 0;
// if (isValid(x, y, memo)) {
// if (x == num - 1)
// return 1;
// for (int i = 0; i < num; i++) {
// memo[x + 1] = i;
// count = count + dfs(x + 1, i, memo, num);
// }
// }
// return count;
// }

// public static boolean isValid(int x, int y, int[] memo) {
// int curr;
// for (int i = 0; i < x; i++) {
// curr = memo[x - i - 1];
// if (curr == y || (y > 0 && curr == y - i - 1) || curr == y + i + 1)
// return false;
// }
// return true;
// }
// }