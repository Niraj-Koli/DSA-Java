/*
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GroupAnagrams {

    // Time -> O(n * m * log(m)) //
    // Space -> O(n * m) //

    private static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<String>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<ArrayList<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println(groupAnagrams(strs));
    }
}