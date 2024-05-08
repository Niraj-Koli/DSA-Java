/*
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * 
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots
 * can be matched with any letter.
 */

// Time -> O(m) //
// Space -> O(n * m) //

class WordDictionary {
    private static class TrieNode {
        private TrieNode[] links;
        private boolean flag;

        public TrieNode() {
            links = new TrieNode[26];
            flag = false;
        }

        public boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return match(word, 0, root);
    }

    private boolean match(String word, int k, TrieNode node) {
        if (k == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(k);

        if (ch != '.') {
            return node.containsKey(ch) && match(word, k + 1, node.get(ch));
        } else {
            for (TrieNode child : node.links) {
                if (child != null && match(word, k + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}