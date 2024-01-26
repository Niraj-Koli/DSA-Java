/*
 * Given a string of length N of lowercase alphabet characters. The task is to
 * complete the function countDistinctSubstring(), which returns the count of
 * total number of distinct substrings of this string.
 */

public class NumberOfDistinctSubstringsInAString {
    static class TrieNode {
        TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[26];
        }

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

    public static int countDistinctSubstrings(String str) {
        int n = str.length();

        TrieNode root = new TrieNode();

        int count = 0;

        for (int i = 0; i < n; i++) {
            TrieNode node = root;

            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);

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
        String str = "abab";

        int answer = countDistinctSubstrings(str);

        System.out.println(answer);
    }
}
