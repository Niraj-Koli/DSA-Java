/*
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * 
 * Return the sorted string. If there are multiple answers, return any of them.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            char key = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                res.append(key);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "tree";

        System.out.println(frequencySort(s));
    }
}