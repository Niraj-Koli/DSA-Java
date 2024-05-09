/* Given a string, find all the possible subsequences of the string. */

import java.util.ArrayList;

class GenerateSubsequencesOfTheString {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(String s, int index, String temp, ArrayList<String> res) {
        if (index == s.length()) {
            res.add(temp);
            return;
        }

        solve(s, index + 1, temp + s.charAt(index), res);

        solve(s, index + 1, temp, res);
    }

    private static ArrayList<String> generateSubsequences(String s) {
        ArrayList<String> res = new ArrayList<String>();

        solve(s, 0, "", res);

        return res;
    }

    public static void main(String[] args) {
        String s = "abc";

        System.out.println(generateSubsequences(s));
    }
}