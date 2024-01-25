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

public class ImplementTrieII {
    class TrieNode {
        TrieNode[] links;
        int countEndsWith;
        int countPrefix;

        public TrieNode() {
            links = new TrieNode[26];
            countEndsWith = 0;
            countPrefix = 0;
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

        void increaseEnd() {
            countEndsWith++;
        }

        void increasePrefix() {
            countPrefix++;
        }

        void deleteEnd() {
            countEndsWith--;
        }

        void reducePrefix() {
            countPrefix--;
        }

        int getEnd() {
            return countEndsWith;
        }

        int getPrefix() {
            return countPrefix;
        }
    }

    private TrieNode root;

    ImplementTrieII() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
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

    public static void main(String[] args) {
        ImplementTrieII trie = new ImplementTrieII();

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