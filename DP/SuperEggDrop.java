/*
 * You are given k identical eggs and you have access to a building with n
 * floors labeled from 1 to n.
 * 
 * You know that there exists a floor f where 0 <= f <= n such that any egg
 * dropped at a floor higher than f will break, and any egg dropped at or below
 * floor f will not break.
 * 
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1
 * <= x <= n). If the egg breaks, you can no longer use it. However, if the egg
 * does not break, you may reuse it in future moves.
 * 
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 */

public class SuperEggDrop {
    public static int[][] dp;

    public static int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];

        return eggDrop(k, n);
    }

    public static int eggDrop(int e, int f) {
        if (f == 0 || f == 1 || e == 1) {
            return dp[e][f] = f;
        }

        if (dp[e][f] != 0) {
            return dp[e][f];
        }

        int low = 1;
        int high = f;

        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            int a = eggDrop(e - 1, middle - 1);
            int b = eggDrop(e, f - middle);

            int ans = 1 + Math.max(a, b);

            min = Math.min(min, ans);

            if (a > b) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        dp[e][f] = min;

        return dp[e][f];
    }

    public static void main(String[] args) {
        int k = 7;
        int n = 10000;

        int answer = superEggDrop(k, n);

        System.out.println(answer);
    }
}

// class Solution {

// public int superEggDrop(int eggs, int floors) {
// int drops = 0;
// int[][] floor = new int[2][eggs + 1];
// for (; floor[0][eggs] < floors; drops++) {
// int[] floorWithPrevDrops = floor[0];
// int[] floorWithCurrDrops = floor[1];
// for (int k = 1; k <= eggs; k++) {
// floorWithCurrDrops[k] = 1 + floorWithPrevDrops[k - 1] +
// floorWithPrevDrops[k];
// }
// floor[0] = floorWithCurrDrops;
// floor[1] = floorWithPrevDrops;
// }
// return drops;
// }
// }