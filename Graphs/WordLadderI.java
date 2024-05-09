/*
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
 * be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the
 * number of words in the shortest transformation sequence from beginWord to
 * endWord, or 0 if no such sequence exists.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class WordLadderI {
    private static class Pair {
        private String word;
        private int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    // Time -> O(n * l) //
    // Space -> O(n) //

    private static int ladderLength(String beginWord, String endWord, ArrayList<String> wordList) {
        int n = wordList.size();

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(beginWord, 1));

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;

                    String newWord = new String(charArray);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        queue.offer(new Pair(newWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}