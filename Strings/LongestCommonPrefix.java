/*
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 */

import java.util.Arrays;

class LongestCommonPrefix {

    // Time -> O((n * log(n)) + m) //
    // Space -> O(1) //

    private static String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        Arrays.sort(strs);

        String str1 = strs[0];
        String str2 = strs[n - 1];

        int n1 = str1.length();
        int n2 = str2.length();

        int index = 0;

        while (index < n1 && index < n2) {
            if (str1.charAt(index) != str2.charAt(index)) {
                break;
            }
            index++;
        }

        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };

        System.out.println(longestCommonPrefix(strs));
    }
}