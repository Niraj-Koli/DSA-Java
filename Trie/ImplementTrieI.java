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

public class ImplementTrieI {
    class TrieNode {
        TrieNode[] links;
        boolean flag;

        public TrieNode() {
            links = new TrieNode[26];
            flag = false;
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

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    private TrieNode root;

    ImplementTrieI() {
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
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
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

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrieI trie = new ImplementTrieI();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

// class Trie {

// ArrayList<String> list;

// public Trie() {
// list = new ArrayList<>();
// }

// public void insert(String word) {
// list.add(word);
// }

// public boolean search(String word) {
// return list.contains(word);
// }

// public boolean startsWith(String prefix) {
// for (int i = 0; i < list.size(); i++) {
// if (list.get(i).startsWith(prefix)) {
// return true;
// }
// }
// return false;
// }
// }
