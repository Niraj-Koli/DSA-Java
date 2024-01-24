/*
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String regex = "[^A-Za-z0-9]";

        String str = s.replaceAll(regex, "").toLowerCase();

        int n = str.length();

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        boolean answer = isPalindrome(s);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isPalindrome(String s) {
// if (s.isEmpty()) {
// return true;
// }
// int st = 0;
// int end = s.length() - 1;
// while (st < end) {
// char currfirst = s.charAt(st);
// char currlast = s.charAt(end);
// if (!Character.isLetterOrDigit(currfirst)) {
// st++;
// } else if (!Character.isLetterOrDigit(currlast)) {
// end--;
// } else {
// if (Character.toLowerCase(currfirst) != Character.toLowerCase(currlast)) {
// return false;
// }
// st++;
// end--;
// }
// }
// return true;
// }
// }