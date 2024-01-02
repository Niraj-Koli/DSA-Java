/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
 * of the grid.
 * The '.' character indicates empty cells.
 */

public class SudokuSolver {
    public static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }

            if (board[row][i] == ch) {
                return false;
            }

            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == ch) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}

// class Solution {
// public void solveSudoku(char[][] board) {
// helper(board);
// return;
// }

// public boolean helper(char[][] board) {
// int row = 0;
// int col = 0;
// boolean isBoxUnfilled = false;
// for (int i = 0; i < 9; i++) {
// for (int j = 0; j < 9; j++) {
// if (board[i][j] == '.') {
// row = i;
// col = j;
// isBoxUnfilled = true;
// break;
// }
// }
// if (isBoxUnfilled) {
// break;
// }
// }
// if (!isBoxUnfilled) {
// return true;
// }
// for (int num = 1; num <= 9; num++) {
// if (isSafe(board, row, col, num)) {
// board[row][col] = (char) (num + '0');
// if (helper(board)) {
// return true;
// } else {
// board[row][col] = '.';
// }
// }
// }
// return false;
// }

// public boolean isSafe(char[][] board, int row, int col, int num) {
// for (int i = 0; i < 9; i++) {
// if (board[row][i] == (char) (num + '0'))
// return false;
// }
// for (int i = 0; i < 9; i++) {
// if (board[i][col] == (char) (num + '0'))
// return false;
// }
// int rowStart = row - row % 3;
// int colStart = col - col % 3;
// for (int i = rowStart; i < rowStart + 3; i++) {
// for (int j = colStart; j < colStart + 3; j++) {
// if (board[i][j] == (char) (num + '0'))
// return false;
// }
// }
// return true;
// }
// }
