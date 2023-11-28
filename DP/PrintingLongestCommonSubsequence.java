/*
 * Given two sequences, print the longest subsequence present in both of them.
 */

public class PrintingLongestCommonSubsequence {
    public static String printLCS(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result.append(x.charAt(i - 1));

                i--;
                j--;
            } else {
                if (t[i][j - 1] > t[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        String answer = printLCS(x, y);

        System.out.println(answer);
    }
}