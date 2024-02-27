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

// Time -> O(N x word.length x 26)
// Space -> O(N)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordLadderI {
    private static class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(beginWord, 1));

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int level = queue.peek().level;
            queue.poll();

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

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        int ans = ladderLength(beginWord, endWord, wordList);

        System.out.println(ans);
    }
}

// class Solution {
// public int ladderLength(String beginWord, String endWord, List<String>
// wordList) {

// if (!wordList.contains(endWord))
// return 0;
// int ans = 0;
// HashSet<String> visited = new HashSet<>();
// visited.add(beginWord);

// Queue<String> q = new LinkedList<>();
// q.add(beginWord);
// // ans++;

// while (!q.isEmpty()) {
// int size = q.size(); // New size variable to keep track of the current level

// for (int i = 0; i < size; i++) {
// String cur = q.remove();

// if (cur.equals(endWord))
// return ans + 1; // Return ladder length if endWord is found

// for (String neighbor : getNeighbors(cur, wordList)) {
// if (!visited.contains(neighbor)) {
// visited.add(neighbor);
// q.add(neighbor);
// }
// }
// }

// ans++;
// }

// return 0;
// }

// public static List<String> getNeighbors(String cur, List<String> wordList) {
// List<String> neighbors = new ArrayList<>();

// for (String s : wordList) {
// int noOfDifferentChar = 0;
// for (int i = 0; i < cur.length(); i++) {
// if (cur.charAt(i) != s.charAt(i)) {
// noOfDifferentChar++;
// }
// }
// if (noOfDifferentChar == 1)
// neighbors.add(s);
// }
// return neighbors;
// }
// }