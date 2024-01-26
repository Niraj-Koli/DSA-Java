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
import java.util.Comparator;

public class MaximumXORWithAnElementFromArray {
    static class TrieNode {
        TrieNode links[];

        public TrieNode() {
            links = new TrieNode[2];
        }

        boolean containsKey(int bit) {
            return (links[bit] != null);
        }

        TrieNode get(int bit) {
            return links[bit];
        }

        void put(int bit, TrieNode node) {
            links[bit] = node;
        }
    }

    static class Trie {
        private static TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (!node.containsKey(bit)) {
                    node.put(bit, new TrieNode());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
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

    public static int[] maximizeXor(int[] nums, int[][] queries) {
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

        Arrays.sort(offlineQueries, Comparator.comparingInt(a -> a[0]));

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

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// class Solution {

// private static class TrieNode {
// public TrieNode left, right;
// }

// private static class Query implements Comparable<Query> {
// public int x, m, idx;

// public Query(int x, int m, int idx) {
// this.x = x;
// this.m = m;
// this.idx = idx;
// }

// @Override
// public int compareTo(Query query) {
// return this.m - query.m;
// }
// }

// public int[] maximizeXor(int[] nums, int[][] queries) {
// Arrays.sort(nums);
// int[] ans = new int[queries.length];
// Arrays.fill(ans, -1);
// List<Query> queryList = new ArrayList<>();
// for (int i = 0; i < queries.length; i++) {
// int x = queries[i][0], m = queries[i][1];
// queryList.add(new Query(x, m, i));
// }
// Collections.sort(queryList);
// TrieNode root = new TrieNode();
// int nextIdx = 0;
// for (Query query : queryList) {
// while (nextIdx < nums.length && nums[nextIdx] <= query.m) {
// insert(root, nums[nextIdx]);
// nextIdx++;
// }
// // root and query.x
// ans[query.idx] = get(root, query.x);
// }
// return ans;
// }

// private int get(TrieNode root, int x) {
// int ans = 0;
// for (int i = 30 - 1; i >= 0; i--) {
// if ((x & (1 << i)) != 0) {
// if (root.left != null) {
// root = root.left;
// ans = ans | (1 << i);
// } else if (root.right != null) {
// root = root.right;
// } else {
// return -1;
// }
// } else {
// if (root.right != null) {
// root = root.right;
// ans = ans | (1 << i);
// } else if (root.left != null) {
// root = root.left;
// } else {
// return -1;
// }
// }
// }
// return ans;
// }

// private void insert(TrieNode root, int val) {
// for (int i = 30 - 1; i >= 0; i--) {
// if ((val & (1 << i)) != 0) {
// if (root.right == null) {
// root.right = new TrieNode();
// }
// root = root.right;
// } else {
// if (root.left == null) {
// root.left = new TrieNode();
// }
// root = root.left;
// }
// }
// }

// }