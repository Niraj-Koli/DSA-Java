/*
 * Given a boolean str S of length N with following symbols.
 * Symbols
 * 'T' ---> true
 * 'F' ---> false
 * and following operators filled between symbols
 * Operators
 * & ---> boolean AND
 * | ---> boolean OR
 * ^ ---> boolean XOR
 * Count the number of ways we can parenthesize the str so that the value
 * of str evaluates to true.
 */

import java.util.Arrays;

public class BooleanParenthesization {
    public static int[][][] dp;

    public static int countWays(String s) {
        int n = s.length();

        dp = new int[n][n][2];

        for (int[][] row : dp) {
            for (int[] innerRow : row) {
                Arrays.fill(innerRow, -1);
            }
        }

        return parenthesization(s, 0, n - 1, true);
    }

    public static int parenthesization(String str, int i, int j, boolean isTrue) {
        if (i > j)
            return 0;

        if (dp[i][j][isTrue ? 1 : 0] != -1) {
            return dp[i][j][isTrue ? 1 : 0];
        }

        if (i == j) {
            return (isTrue && str.charAt(i) == 'T') || (!isTrue && str.charAt(i) == 'F') ? 1 : 0;
        }

        int ways = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftTrue = (dp[i][k - 1][1] == -1) ? parenthesization(str, i, k - 1, true) : dp[i][k - 1][1];
            int leftFalse = (dp[i][k - 1][0] == -1) ? parenthesization(str, i, k - 1, false) : dp[i][k - 1][0];
            int rightTrue = (dp[k + 1][j][1] == -1) ? parenthesization(str, k + 1, j, true) : dp[k + 1][j][1];
            int rightFalse = (dp[k + 1][j][0] == -1) ? parenthesization(str, k + 1, j, false) : dp[k + 1][j][0];

            if (str.charAt(k) == '&') {
                ways += (isTrue ? (leftTrue * rightTrue)
                        : ((leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse)));
            } else if (str.charAt(k) == '|') {
                ways += (isTrue ? ((leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue))
                        : (leftFalse * rightFalse));
            } else if (str.charAt(k) == '^') {
                ways += (isTrue ? ((leftTrue * rightFalse) + (leftFalse * rightTrue))
                        : ((leftTrue * rightTrue) + (leftFalse * rightFalse)));
            }
        }

        dp[i][j][isTrue ? 1 : 0] = ways;

        return dp[i][j][isTrue ? 1 : 0];
    }

    public static void main(String[] args) {
        String s = "T^F&T";

        int answer = countWays(s);

        System.out.println(answer);
    }
}