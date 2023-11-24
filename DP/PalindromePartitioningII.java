/*
 * Given a string s, partition s such that every
 * substring
 * of the partition is a
 * palindrome
 * .
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */

public class PalindromePartitioningII {
    public static int[][] t;

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static int minCut(String s) {
        int n = s.length();

        t = new int[n][n];

        return palindromeCuts(s, 0, n - 1);
    }

    public static int palindromeCuts(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        if (t[i][j] != 0) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int left = t[i][k] != 0 ? t[i][k] : palindromeCuts(s, i, k);
            int right = t[k + 1][j] != 0 ? t[k + 1][j] : palindromeCuts(s, k + 1, j);

            int cuts = 1 + left + right;

            min = Math.min(min, cuts);
        }

        t[i][j] = min;

        return t[i][j];
    }

    public static int minPalPartion(String s) {
        int n = s.length();

        int[][] cuts = new int[n][n];
        boolean[][] palindrome = new boolean[n][n];

        int i, j, k, L;

        for (i = 0; i < n; i++) {
            palindrome[i][i] = true;
            cuts[i][i] = 0;
        }

        for (L = 2; L <= n; L++) {
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1;

                if (L == 2) {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j))
                            && palindrome[i + 1][j - 1];
                }

                if (palindrome[i][j] == true) {
                    cuts[i][j] = 0;
                } else {
                    cuts[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        cuts[i][j] = Integer.min(
                                cuts[i][j],
                                cuts[i][k] + cuts[k + 1][j] + 1);
                }
            }
        }

        return cuts[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "abbac";

        int answer = minPalPartion(s);

        System.out.println(answer);
    }
}