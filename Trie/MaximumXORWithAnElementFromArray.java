/*
 * You are given an array nums consisting of non-negative integers. You are also
 * given a queries array, where queries[i] = [xi, mi].
 * 
 * The answer to the ith query is the maximum bitwise XOR value of xi and any
 * element of nums that does not exceed mi. In other words, the answer is
 * max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in
 * nums are larger than mi, then the answer is -1.
 * 
 * Return an integer array answer where answer.length == queries.length and
 * answer[i] is the answer to the ith query.
 */

import java.util.Arrays;

class MaximumXORWithAnElementFromArray {
    private static class TrieNode {
        private TrieNode links[];

        public TrieNode() {
            links = new TrieNode[2];
        }

        private boolean containsKey(int bit) {
            return (links[bit] != null);
        }

        private TrieNode get(int bit) {
            return links[bit];
        }

        private void put(int bit, TrieNode node) {
            links[bit] = node;
        }
    }

    private static class Trie {
        private static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Time -> O(1) //
        // Space -> O(1) //

        private void insert(int num) {
            TrieNode node = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (!node.containsKey(bit)) {
                    node.put(bit, new TrieNode());
                }
                node = node.get(bit);
            }
        }

        // Time -> O(1) //
        // Space -> O(1) //

        private int getMax(int num) {
            TrieNode node = root;
            int maxNum = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }

            return maxNum;
        }
    }

    // Time -> O((n + m) * log(n)) //
    // Space -> O(m) //

    private static int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);

        int[][] offlineQueries = new int[m][3];

        for (int i = 0; i < m; i++) {
            int[] oQ = new int[3];
            oQ[0] = queries[i][1];
            oQ[1] = queries[i][0];
            oQ[2] = i;
            offlineQueries[i] = oQ;
        }

        Arrays.sort(offlineQueries, (a, b) -> a[0] - b[0]);

        int index = 0;

        Trie trie = new Trie();

        int[] res = new int[m];

        Arrays.fill(res, -1);

        for (int i = 0; i < m; i++) {
            while (index < n && nums[index] <= offlineQueries[i][0]) {
                trie.insert(nums[index]);
                index++;
            }

            int queryIndex = offlineQueries[i][2];

            if (index != 0) {
                res[queryIndex] = trie.getMax(offlineQueries[i][1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[][] queries = { { 3, 1 }, { 1, 3 }, { 5, 6 } };

        int[] answer = maximizeXor(nums, queries);

        for (int an : answer) {
            System.out.print(an + " ");
        }
    }
}