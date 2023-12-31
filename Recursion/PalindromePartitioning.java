/*
 * Given a string s, partition s such that every
 * substring
 * of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void solve(String s, int index, List<String> path, List<List<String>> result) {
        int n = s.length();

        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                solve(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        solve(s, 0, new ArrayList<String>(), result);

        return result;
    }

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> answer = partition(s);

        System.out.println(answer);
    }
}

// class Solution {
// int n;
// boolean[][] is_palindrome;
// String[][] substrings;

// List<List<String>> ans;

// void FindSubstrings(int ind, ArrayList<String> list) {
// if (ind == n) {
// ans.add(new ArrayList<String>(list));
// return;
// }

// for (int i = ind + 1; i <= n; i++) {
// if (!is_palindrome[ind][i])
// continue;
// list.add(substrings[ind][i]);
// FindSubstrings(i, list);
// list.remove(list.size() - 1);
// }
// }

// public List<List<String>> partition(String s) {
// n = s.length();
// is_palindrome = new boolean[n + 1][n + 1];
// substrings = new String[n + 1][n + 1];
// for (int i = 0; i < n; i++)
// for (int j = i + 1; j <= n; j++) {
// substrings[i][j] = s.substring(i, j);
// is_palindrome[i][j] = IsPalindrome(substrings[i][j]);
// }

// ans = new ArrayList<List<String>>();
// FindSubstrings(0, new ArrayList<String>());
// return ans;
// }

// boolean IsPalindrome(String s) {
// int lower = 0;
// int higher = s.length() - 1;
// while (lower < higher) {
// if (s.charAt(lower) != s.charAt(higher))
// return false;
// lower++;
// higher--;
// }
// return true;
// }
// }