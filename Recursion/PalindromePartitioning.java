/*
 * Given a string s, partition s such that every
 * substring
 * of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 */

import java.util.ArrayList;

class PalindromePartitioning {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private static void solve(String s, int index, ArrayList<String> path, ArrayList<ArrayList<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                solve(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        solve(s, 0, new ArrayList<String>(), res);

        return res;
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println(partition(s));
    }
}