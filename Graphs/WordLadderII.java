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
import java.util.List;

public class WordLadderII {
    static String b;
    static HashMap<String, Integer> map;
    static List<List<String>> res;

    public static void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            res.add(dup);
            return;
        }

        int steps = map.get(word);
        int n = word.length();

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

    public static List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
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

        res = new ArrayList<List<String>>();

        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<String>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return res;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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

        List<List<String>> res = new ArrayList<List<String>>();

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

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        List<List<String>> ans = findSequences(beginWord, endWord, wordList);

        System.out.println(ans);
    }
}

// class Solution {
// List<List<String>> ans = new ArrayList<>();
// Map<String, Integer> wordToId = new HashMap<>();
// Map<Integer, String> idToWord = new HashMap<>();
// Map<Integer, List<Integer>> path = new HashMap<Integer, List<Integer>>();
// Deque<String> list = new LinkedList<>();
// int[] ne, e, h;
// boolean[] vis;
// int len, idx, start, end;

// void add(int u, int v) {
// e[++len] = v;
// ne[len] = h[u];
// h[u] = len;
// }

// public List<List<String>> findLadders(String beginWord, String endWord,
// List<String> wordList) {
// int n = wordList.size();
// ne = new int[20 * n];
// e = new int[20 * n];
// h = new int[20 * n];
// vis = new boolean[10 * n];
// if (!wordList.contains(beginWord))
// wordList.add(beginWord);
// if (!wordList.contains(endWord))
// return ans;
// for (int i = 0; i < wordList.size(); i++)
// addEdge(wordList.get(i));
// Queue<Integer> q = new LinkedList<>();
// start = wordToId.get(beginWord);
// end = wordToId.get(endWord);
// q.add(start);
// while (!q.isEmpty()) {
// int u = q.poll();
// if (u == end)
// break;
// if (vis[u])
// continue;
// vis[u] = true;
// for (int j = h[u]; j != 0; j = ne[j]) {
// int v = e[j];
// if (vis[v])
// continue;
// if (!path.containsKey(v))
// path.put(v, new ArrayList<>());
// path.get(v).add(u);
// q.add(v);
// }
// }
// list.add(endWord);
// dfs(end, 0);
// return ans;
// }

// void dfs(int u, int level) {
// if (u == start) {
// ans.add(new ArrayList<>(list));
// return;
// }
// List<Integer> p = path.get(u);
// if (p == null)
// return;
// for (int i = 0; i < p.size(); i++) {
// int v = p.get(i);
// if (level % 2 == 1)
// list.addFirst(idToWord.get(v));
// dfs(v, level + 1);
// if (level % 2 == 1)
// list.pollFirst();
// }
// }

// void addEdge(String word) {
// int u = idx;
// char[] arr = word.toCharArray();
// wordToId.put(word, idx);
// idToWord.put(idx++, word);
// for (int i = 0; i < arr.length; i++) {
// char t = arr[i];
// arr[i] = '*';
// String vstr = new String(arr);
// if (!wordToId.containsKey(vstr)) {
// wordToId.put(vstr, idx);
// idToWord.put(idx++, vstr);
// }
// int v = wordToId.get(vstr);
// add(u, v);
// add(v, u);
// arr[i] = t;
// }
// }
// }


