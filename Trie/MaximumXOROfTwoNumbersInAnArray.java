/*
 * Given an integer array nums, return the maximum result of nums[i] XOR
 * nums[j], where 0 <= i <= j < n.
 */

class MaximumXOROfTwoNumbersInAnArray {
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

    // Time -> O(n) //
    // Space -> O(n) //

    private static int findMaximumXOR(int[] nums) {
        int n = nums.length;

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(nums[i]);
        }

        int maxXOR = 0;

        for (int i = 0; i < n; i++) {
            maxXOR = Math.max(maxXOR, trie.getMax(nums[i]));
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };

        System.out.println(findMaximumXOR(nums));
    }
}