/*
 * Implement a data structure ”TRIE” from scratch. Complete some functions.
 * 
 * 1) Trie(): Initialize the object of this “TRIE” data structure.
 * 
 * 2) insert(“WORD”): Insert the string “WORD” into this “TRIE” data structure.
 * 
 * 3) countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in
 * this “TRIE”.
 * 
 * 4) countWordsStartingWith(“PREFIX”): Return how many words are there in this
 * “TRIE” that have the string “PREFIX” as a prefix.
 * 
 * 5) erase(“WORD”): Delete this string “WORD” from the “TRIE”.
 */

class ImplementTrieII {

    // Time -> O(1) //
    // Space -> O(1) //

    private static class TrieNode {
        private TrieNode[] links;
        private int countEndsWith;
        private int countPrefix;

        public TrieNode() {
            links = new TrieNode[26];
            countEndsWith = 0;
            countPrefix = 0;
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

        private void increaseEnd() {
            countEndsWith++;
        }

        private void increasePrefix() {
            countPrefix++;
        }

        private void deleteEnd() {
            countEndsWith--;
        }

        private void reducePrefix() {
            countPrefix--;
        }

        private int getEnd() {
            return countEndsWith;
        }

        private int getPrefix() {
            return countPrefix;
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
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
                node.increasePrefix();
            }
            node.increaseEnd();
        }

        // Time -> O(n) //
        // Space -> O(1) //

        private int countWordsEqualTo(String word) {
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return 0;
                }
            }

            return node.getEnd();
        }

        // Time -> O(n) //
        // Space -> O(1) //

        private int countWordsStartingWith(String word) {
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return 0;
                }
            }

            return node.getPrefix();
        }

        // Time -> O(n) //
        // Space -> O(1) //

        private void erase(String word) {
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    node.reducePrefix();
                } else {
                    return;
                }
            }

            node.deleteEnd();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apps");
        System.out.println(trie.countWordsEqualTo("apps"));
        System.out.println(trie.countWordsEqualTo("abc"));
        System.out.println(trie.countWordsStartingWith("ap"));
        System.out.println(trie.countWordsStartingWith("appl"));
        trie.erase("apps");
        System.out.println(trie.countWordsEqualTo("apps"));
    }
}