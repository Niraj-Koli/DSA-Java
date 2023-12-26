/*
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;

        int[] answer = countBits(n);

        System.out.println(Arrays.toString(answer));
    }
}

// class Solution {
// public int[] countBits(int num) {
// if (num == 0) {
// return new int[] { 0 };
// }
// int[] dp = new int[num + 1];
// for (int i = 1; i <= num; i++) {
// if (i % 2 == 1) {
// dp[i] = 1;
// }
// dp[i] += dp[i >> 1];
// }
// return dp;
// }
// }