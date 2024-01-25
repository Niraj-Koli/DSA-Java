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

public class LongestWordWithAllPrefixes {
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

    LongestWordWithAllPrefixes() {
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

    public boolean chechIfPrefixExists(String word) {
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

    public static void main(String[] args) {
        String[] words = { "n", "ni", "nin", "ninj", "ninja", "ninga" };
        int n = words.length;

        LongestWordWithAllPrefixes trie = new LongestWordWithAllPrefixes();

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

        if (longest == "") {
            System.out.println("None");
        } else {
            System.out.println(longest);
        }
    }
}