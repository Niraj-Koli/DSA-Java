/*
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void solve(String digits, HashMap<Character, String> map, int index, StringBuilder str,
            List<String> res) {
        if (str.length() >= digits.length()) {
            if (!str.isEmpty()) {
                res.add(str.toString());
            }
            return;
        }

        for (int i = 0; i < map.get(digits.charAt(index)).length(); i++) {
            str.append(map.get(digits.charAt(index)).charAt(i));
            solve(digits, map, index + 1, str, res);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<String>();

        solve(digits, map, 0, new StringBuilder(), res);

        return res;
    }

    public static void main(String[] args) {
        String digits = "23";

        List<String> ans = letterCombinations(digits);

        System.out.println(ans);
    }
}

// class Solution {
// public List<String> letterCombinations(String digits) {
// if (digits.length() == 0)
// return new ArrayList<>();
// Map<String, List<String>> map = new HashMap<>();
// map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
// map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
// map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
// map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
// map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
// map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
// map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
// map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
// if (digits.length() == 1) {
// return map.get(digits);
// }
// List<String> res = new ArrayList<>();
// for (char ch : digits.toCharArray()) {
// List<String> temp = map.get(String.valueOf(ch));
// if (res.isEmpty())
// res = temp;
// else {
// List<String> temp2 = new ArrayList<>();
// for (int i = 0; i < res.size(); i++) {
// for (int j = 0; j < temp.size(); j++) {
// temp2.add(res.get(i) + temp.get(j));
// }
// }
// res = temp2;
// }
// }
// return res;

// }
// }