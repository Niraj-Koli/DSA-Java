/*
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 */

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int n = s.length();

        int i = 0;
        int j = 0;

        int[] arr = new int[26];

        int max = 0;
        int res = 0;

        while (j < n) {
            arr[s.charAt(j) - 'A']++;

            max = Math.max(max, arr[s.charAt(j) - 'A']);

            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(max, j - i + 1);

            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int ans = characterReplacement(s, k);

        System.out.println(ans);
    }
}

// class Solution {
// public int characterReplacement(String s, int k) {
// char[] c = s.toCharArray();
// int[] chars = new int[26];
// int left = 0;
// int max = 0;
// int total = 0;
// int maxTotal = 0;
// for (int i = 0; i < c.length; i++) {
// char ch = c[i];
// max = Math.max(max, ++chars[ch - 'A']);
// total++;
// while (total - max > k) {
// chars[c[left] - 'A']--;
// left++;
// total--;
// }
// if (total > maxTotal)
// maxTotal = total;
// }
// return maxTotal;
// }
// }
