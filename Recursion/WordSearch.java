/*
 * Given an m j n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 */

public class WordSearch {

    // Time -> O(n * m * 4^n) //
    // Space -> O(n) //

    private static boolean dfs(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }

        if (board[i][j] != word[index]) {
            return false;
        }

        board[i][j] ^= 256;

        boolean exist = dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1)
                || dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1);

        board[i][j] ^= 256;

        return exist;
    }

    private static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        char[] letter = word.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, letter, 0))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' },
        };
        String word = "SEE";

        System.out.println(exist(board, word));
    }
}