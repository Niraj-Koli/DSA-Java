/*
 * Given a string of length N of lowercase alphabet characters. The task is to
 * complete the function countDistinctSubstring(), which returns the count of
 * total number of distinct substrings of this string.
 */

class NumberOfDistinctSubstringsInAString {
    private static class TrieNode {
        private TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[26];
        }

        private boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        private TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        private void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    }

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int countDistinctSubstrings(String s) {
        int n = s.length();

        TrieNode root = new TrieNode();

        int count = 0;

        for (int i = 0; i < n; i++) {
            TrieNode node = root;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                    count++;
                }
                node = node.get(ch);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String s = "abab";

        System.out.println(countDistinctSubstrings(s));
    }
}
