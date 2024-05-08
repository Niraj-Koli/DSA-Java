/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 */

class ImplementTrieI {

    // Time -> O(1) //
    // Space -> O(1) //

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
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
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

        private boolean search(String word) {
            int n = word.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }

            if (node.isEnd()) {
                return true;
            }

            return false;
        }

        // Time -> O(n) //
        // Space -> O(1) //

        private boolean startsWith(String prefix) {
            int n = prefix.length();

            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);

                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}