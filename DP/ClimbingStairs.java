/*
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] t = new int[n + 1];

        t[0] = 1;
        t[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            t[i] = t[i - 1] + t[i - 2];
        }

        return t[n];
    }

    public static void main(String[] args) {
        int n = 2;

        int answer = climbStairs(n);

        System.out.println(answer);
    }
}

// class Solution {
// public int climbStairs(int n) {
// if (n == 0 || n == 1) {
// return 1;
// }

// int[] t = new int[n + 1];
// t[0] = t[1] = 1;

// for (int i = 2; i <= n; i++) {
// t[i] = t[i - 1] + t[i - 2];
// }
// return t[n];
// }
// }