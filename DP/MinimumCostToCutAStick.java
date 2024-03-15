/*
 * Given a wooden stick of length n units. The stick is labelled from 0 to n.
 * For example, a stick of length 6 is labelled as follows:
 * 
 * 
 * Given an integer array cuts where cuts[i] denotes a position you should
 * perform a cut at.
 * 
 * You should perform the cuts in order, you can change the order of the cuts as
 * you wish.
 * 
 * The cost of one cut is the length of the stick to be cut, the total cost is
 * the sum of costs of all cuts. When you cut a stick, it will be split into two
 * smaller sticks (i.e. the sum of their lengths is the length of the stick
 * before the cut). Please refer to the first example for a better explanation.
 * 
 * Return the minimum total cost of the cuts.
 */

import java.util.Arrays;

public class MinimumCostToCutAStick {

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static int minCost(int n, int[] cuts) {
        int c = cuts.length;

        Arrays.sort(cuts);

        int[] newCuts = new int[c + 2];

        newCuts[0] = 0;
        newCuts[c + 1] = n;

        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }

        int[][] dp = new int[c + 2][c + 2];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) {
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int res = newCuts[j + 1] - newCuts[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    
                    min = Math.min(min, res);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }

    public static void main(String[] args) {
        int n = 9;
        int[] cuts = { 5, 6, 1, 4, 2 };

        System.out.println(minCost(n, cuts));
    }
}