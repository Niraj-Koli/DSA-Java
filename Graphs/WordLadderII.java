/*
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
 * be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all
 * the shortest transformation sequences from beginWord to endWord, or an empty
 * list if no such sequence exists. Each sequence should be returned as a list
 * of the words [beginWord, s1, s2, ..., sk].
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class WordLadderII {
    private static String b;
    private static HashMap<String, Integer> map;
    private static ArrayList<ArrayList<String>> res;

    private static void dfs(String word, ArrayList<String> seq) {
        if (word.equals(b)) {
            ArrayList<String> dup = new ArrayList<String>(seq);
            Collections.reverse(dup);
            res.add(dup);
            return;
        }

        int n = word.length();

        int steps = map.get(word);

        for (int i = 0; i < n; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] charArray = word.toCharArray();
                charArray[i] = ch;

                String newWord = new String(charArray);

                if (map.containsKey(newWord) && map.get(newWord) + 1 == steps) {
                    seq.add(newWord);
                    dfs(newWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    // Time -> O((n * l)^2) //
    // Space -> O((n * l)^2) //

    private static ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord,
            ArrayList<String> wordList) {
        int n = wordList.size();

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }

        ArrayDeque<String> queue = new ArrayDeque<String>();

        b = beginWord;
        queue.offer(beginWord);

        map = new HashMap<String, Integer>();
        map.put(beginWord, 1);

        int size = beginWord.length();
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            
            int steps = map.get(word);

            if (word.equals(endWord)) {
                break;
            }

            for (int i = 0; i < size; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;

                    String newWord = new String(charArray);

                    if (set.contains(newWord)) {
                        queue.offer(newWord);
                        set.remove(newWord);
                        map.put(newWord, steps + 1);
                    }
                }
            }
        }

        res = new ArrayList<ArrayList<String>>();

        if (map.containsKey(endWord)) {
            ArrayList<String> seq = new ArrayList<String>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return res;
    }

    // Time -> O(n * l) //
    // Space -> O(n * l) //

    private static ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord,
            ArrayList<String> wordList) {
        int n = wordList.size();

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }

        ArrayDeque<ArrayList<String>> queue = new ArrayDeque<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add(beginWord);
        queue.offer(list);

        ArrayList<String> usedOnLevel = new ArrayList<String>();
        usedOnLevel.add(beginWord);

        int level = 0;

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        while (!queue.isEmpty()) {
            ArrayList<String> vec = queue.poll();

            if (vec.size() > level) {
                level++;

                for (String prev : usedOnLevel) {
                    set.remove(prev);
                }
            }

            String word = vec.get(vec.size() - 1);

            if (word.equals(endWord)) {
                if (res.size() == 0) {
                    res.add(vec);
                } else if (res.get(0).size() == vec.size()) {
                    res.add(vec);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;

                    String newWord = new String(charArray);

                    if (set.contains(newWord)) {
                        vec.add(newWord);

                        ArrayList<String> newList = new ArrayList<>(vec);
                        queue.offer(newList);

                        usedOnLevel.add(newWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));

        System.out.println(findLadders(beginWord, endWord, wordList));
        System.out.println(findSequences(beginWord, endWord, wordList));
    }
}