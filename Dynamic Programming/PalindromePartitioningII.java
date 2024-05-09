/*
 * Given a string s, partition s such that every
 * substring
 * of the partition is a
 * palindrome
 * .
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */

class PalindromePartitioningII {

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int minCut(String s) {
        int n = s.length();

        int[] cut = new int[n];

        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;

                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }

            cut[i] = min;
        }

        return cut[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println(minCut(s));
    }
}