/*
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 */

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    static class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;

        boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            TrieNode node = root;

            for (char ch : w.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.word = w;
        }

        return root;
    }

    public static void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        int n = board.length;
        int m = board[0].length;

        char ch = board[i][j];

        if (ch == '#' || !node.containsKey(ch)) {
            return;
        }

        node = node.get(ch);

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i > 0) {
            dfs(board, i - 1, j, node, res);
        }

        if (j > 0) {
            dfs(board, i, j - 1, node, res);
        }

        if (i < n - 1) {
            dfs(board, i + 1, j, node, res);
        }

        if (j < m - 1) {
            dfs(board, i, j + 1, node, res);
        }

        board[i][j] = ch;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        List<String> res = new ArrayList<String>();

        TrieNode root = buildTrie(words);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' },
        };
        String[] words = { "oath", "pea", "eat", "rain" };

        List<String> ans = findWords(board, words);

        System.out.println(ans);
    }
}

// class Solution {
// public List<String> findWords(char[][] board, String[] words) {
// char[][] chrs = new char[words.length][];
// for (int i = 0; i < words.length; i++) {
// chrs[i] = words[i].toCharArray();
// }
// boolean[][] seen = new boolean[board.length][board[0].length];
// List<String> res = new ArrayList<>();
// boolean[] found = new boolean[words.length];
// int[] counts = new int['z' + 1];
// int[] max = { -1, -1 };
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board[0].length; j++) {
// counts[board[i][j]]++;
// if (counts[board[i][j]] > max[1]) {
// max[1] = counts[board[i][j]];
// max[0] = (int) board[i][j];
// }
// }
// }
// int a = 0;
// int b = 0;
// for (int i = 0; i < chrs.length; i++) {
// if (chrs[i][0] == (char) max[0]) {
// a++;
// } else {
// b++;
// }
// }
// if (b > a) {
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board[0].length; j++) {
// for (int k = 0; k < words.length; k++) {
// if (!found[k] && board[i][j] == chrs[k][0]) {
// seen[i][j] = true;
// if (dfs(seen, board, chrs[k], i, j, 1))
// found[k] = true;
// seen[i][j] = false;
// }
// }
// }
// }
// } else {
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board[0].length; j++) {
// for (int k = 0; k < words.length; k++) {
// if (!found[k] && board[i][j] == chrs[k][chrs[k].length - 1]) {
// seen[i][j] = true;
// if (dfs1(seen, board, chrs[k], i, j, chrs[k].length - 2))
// found[k] = true;
// seen[i][j] = false;
// }
// }
// }
// }
// }
// for (int i = 0; i < words.length; i++) {
// if (found[i])
// res.add(words[i]);
// }
// return res;
// }

// int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

// public boolean dfs1(boolean[][] seen, char[][] board, char[] chrs, int i, int
// j, int n) {
// if (n == -1)
// return true;
// for (int[] dir : dirs) {
// int x = i + dir[0];
// int y = j + dir[1];
// if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
// !seen[x][y]
// && board[x][y] == chrs[n]) {
// seen[x][y] = true;
// if (dfs1(seen, board, chrs, x, y, n - 1)) {
// seen[x][y] = false;
// return true;
// }
// seen[x][y] = false;
// }
// }
// return false;
// }

// public boolean dfs(boolean[][] seen, char[][] board, char[] chrs, int i, int
// j, int n) {
// if (n == chrs.length)
// return true;
// for (int[] dir : dirs) {
// int x = i + dir[0];
// int y = j + dir[1];
// if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
// !seen[x][y]
// && board[x][y] == chrs[n]) {
// seen[x][y] = true;
// if (dfs(seen, board, chrs, x, y, n + 1)) {
// seen[x][y] = false;
// return true;
// }
// seen[x][y] = false;
// }
// }
// return false;
// }
// }