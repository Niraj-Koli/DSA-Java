/*
 * Given an integer array nums, return the maximum result of nums[i] XOR
 * nums[j], where 0 <= i <= j < n.
 */

public class MaximumXOROfTwoNumbersInAnArray {
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

    public static int findMaximumXOR(int[] nums) {
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

        int answer = findMaximumXOR(nums);

        System.out.println(answer);
    }
}

// class Solution {
// Set<Integer> visited = new HashSet<>();

// public int findMaximumXOR(int[] nums) {

// int max = 0, ans = 0, mask = 0, masks = 0;
// for (int x : nums)
// max = Math.max(max, x);

// int bit = 32;
// while (--bit >= 0)
// if (((max >> bit) & 1) == 1)
// break;

// for (int i = bit; i >= 0; i--) {
// mask = 1 << i;
// masks |= mask;
// if (check(nums, masks, ans | mask))
// ans |= mask;

// visited.clear();
// }
// return ans;
// }

// private boolean check(int[] nums, int masks, int ans) {
// for (int x : nums) {
// x &= masks;
// if (visited.contains(x ^ ans))
// return true;
// visited.add(x);
// }
// return false;
// }

// }