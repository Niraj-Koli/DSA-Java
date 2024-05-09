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

class LetterCombinationsOfAPhoneNumber {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(String digits, HashMap<Character, String> map, int index, StringBuilder str,
            ArrayList<String> res) {
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

    private static ArrayList<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        ArrayList<String> res = new ArrayList<String>();

        solve(digits, map, 0, new StringBuilder(), res);

        return res;
    }

    public static void main(String[] args) {
        String digits = "23";

        System.out.println(letterCombinations(digits));
    }
}