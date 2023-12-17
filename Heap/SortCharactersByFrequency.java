/*
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * 
 * Return the sorted string. If there are multiple answers, return any of them.
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                (a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            maxHeap.offer(key);
        }

        while (!maxHeap.isEmpty()) {
            int freq = map.get(maxHeap.peek());

            for (int i = 0; i < freq; i++) {
                result.append(Character.toString(maxHeap.peek()));
            }
            maxHeap.poll();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";

        String answer = frequencySort(s);

        System.out.println(answer);
    }
}

// class Solution {
// private class Pair {
// char ch;
// int freq;

// public Pair(char ch, int freq) {
// this.ch = ch;
// this.freq = freq;
// }
// }

// public String frequencySort(String s) {
// Pair pr[] = new Pair[123];
// for (int i = 0; i < 123; i++)
// pr[i] = new Pair((char) i, 0);
// for (char ch : s.toCharArray()) {
// pr[ch].freq++;
// }

// Arrays.sort(pr, (a, b) -> b.freq - a.freq);
// StringBuilder ans = new StringBuilder("");
// char arr[] = new char[s.length()];
// int k = 0;

// for (int i = 0; i < pr.length; i++) {
// if (pr[i].freq > 0) {
// for (int j = 0; j < pr[i].freq; j++)
// arr[k++] = pr[i].ch;
// }
// }

// return new String(arr);
// }
// }