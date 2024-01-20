/*
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static int generatePrime(int n) {
        int num = 1;
        int count = 0, i;

        while (count < n) {
            num = num + 1;

            for (i = 2; i <= num; i++) {
                if (num % i == 0) {
                    break;
                }
            }

            if (i == num) {
                count = count + 1;
            }
        }

        return num;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int prime = 1;

        double[] values = new double[n];

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < n; i++) {
            double product = 1;

            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);

                if (!map.containsKey(c)) {
                    map.put(c, generatePrime(prime));
                    prime++;
                }

                int value = map.get(c);

                product *= value;
            }
            values[i] = product;
        }

        int len = values.length;

        HashMap<Double, List<String>> support = new HashMap<Double, List<String>>();

        for (int k = 0; k < len; k++) {
            if (support.containsKey(values[k])) {
                List<String> arr = support.get(values[k]);

                arr.add(strs[k]);
            } else {
                List<String> arr = support.getOrDefault(values[k], new ArrayList<>());

                arr.add(strs[k]);

                support.put(values[k], arr);
            }
        }

        List<List<String>> result = new ArrayList<>(support.values());

        return result;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> answer = groupAnagrams(strs);

        System.out.println(answer);
    }
}

// class Solution {
// public List<List<String>> groupAnagrams(String[] strs) {
// Map<String, List<String>> map = new HashMap<>();
// for (String s : strs) {
// char[] arr = s.toCharArray();
// Arrays.sort(arr);
// String word = new String(arr);
// if (!map.containsKey(word)) {
// map.put(word, new ArrayList<>());
// }
// map.get(word).add(s);
// }
// return new ArrayList<>(map.values());
// }
// }