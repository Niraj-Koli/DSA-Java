/*
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

public class ValidSudoku {
    public static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch && i != row) {
                return false;
            }

            if (board[row][i] == ch && i != col) {
                return false;
            }

            int subgridRow = 3 * (row / 3) + (i / 3);
            int subgridCol = 3 * (col / 3) + (i % 3);

            if (board[subgridRow][subgridCol] == ch && (subgridRow != row) && (subgridCol != col)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
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

        boolean answer = isValidSudoku(board);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isValidSudoku(char[][] board) {
// for (int i = 0; i < board.length; i++) {
// boolean c = checkGroup(board[i]);
// if (!c) {
// return false;
// }
// }
// for (int i = 0; i < board[0].length; i++) {
// char[] arr = new char[9];
// for (int j = 0; j < 9; j++) {
// arr[j] = board[j][i];
// }
// boolean c = checkGroup(arr);
// if (!c) {
// return false;
// }
// }
// for (int i = 0; i < 3; i++) {
// for (int j = 0; j < 3; j++) {
// char[] arr = new char[9];
// for (int k = 0; k < 3; k++) {
// for (int l = 0; l < 3; l++) {
// arr[3 * k + l] = board[3 * i + k][3 * j + l];
// }
// }
// boolean c = checkGroup(arr);
// if (!c) {
// return false;
// }
// }
// }
// return true;
// }

// private boolean checkGroup(char[] group) {
// Map<Character, Integer> m = new HashMap<>();
// for (int i = 0; i < group.length; i++) {
// if (group[i] == '.') {
// continue;
// }
// Integer v = m.get(group[i]);
// if (v != null) {
// return false;
// }
// m.put(group[i], 1);
// }
// return true;
// }
// }