/*
 * Ninja developed a love for arrays and strings so this time his teacher gave
 * him an array of strings, ‘A’ of size ‘N’. Each element of this array is a
 * string. The teacher taught Ninja about prefixes in the past, so he wants to
 * test his knowledge.
 * 
 * A string is called a complete string if every prefix of this string is also
 * present in the array ‘A’. Ninja is challenged to find the longest complete
 * string in the array ‘A’.If there are multiple strings with the same length,
 * return the lexicographically smallest one and if no string exists, return
 * "None".
 */

class LongestWordWithAllPrefixes {
    private static class TrieNode {
        private TrieNode[] links;
        private boolean flag;

        public TrieNode() {
            links = new TrieNode[26];
            flag = false;
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

        private void setEnd() {
            flag = true;
        }

        private boolean isEnd() {
            return flag;
        }
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Time -> O(n) //
        // Space -> O(n * m) //

        private void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        // Time -> O(n) //
        // Space -> O(1) //

        private boolean chechIfPrefixExists(String word) {
            TrieNode node = root;
            boolean flag = true;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);

                    if (!node.isEnd()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return flag;
        }
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static String completeString(String[] words) {
        int n = words.length;

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(words[i]);
        }

        String longest = "";

        for (int i = 0; i < n; i++) {
            if (trie.chechIfPrefixExists(words[i])) {
                if (words[i].length() > longest.length()) {
                    longest = words[i];
                } else if (words[i].length() == longest.length() && words[i].compareTo(longest) < 0) {
                    longest = words[i];
                }
            }
        }

        return longest == "" ? "None" : longest;
    }

    public static void main(String[] args) {
        String[] words = { "n", "ni", "nin", "ninj", "ninja", "ninga" };

        System.out.println(completeString(words));
    }
}