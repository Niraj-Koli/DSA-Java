/*
 * Given an m x n board of characters and a ArrayList of strings words, return all
 * words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 */

import java.util.ArrayList;

class WordSearchII {
    private static class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        private String word;

        public boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    }

    // Time -> O(m * n) //
    // Space -> O(m * n) //

    private static TrieNode buildTrie(String[] words) {
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

    // Time -> O(m * n * 4^l) //
    // Space -> O(l) //

    private static void dfs(char[][] board, int i, int j, TrieNode node, ArrayList<String> res) {
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

    // Time -> O(m * n * 4^l) //
    // Space -> O(m * n + l) //

    private static ArrayList<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        ArrayList<String> res = new ArrayList<String>();

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

        System.out.println(findWords(board, words));
    }
}