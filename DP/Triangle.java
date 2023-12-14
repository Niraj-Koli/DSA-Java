/*
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 */

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int[][] dp = new int[100000][100000];

    static int solve(int i, int j, int[][] triangle, int n) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (i == n - 1) {
            return triangle[i][j];
        }

        int bottom = triangle[i][j] + solve(i + 1, j, triangle, n);
        int diagonal = triangle[i][j] + solve(i + 1, j + 1, triangle, n);

        dp[i][j] = Math.min(bottom, diagonal);

        return dp[i][j];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[][] = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {

                int bottom = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(bottom, diagonal);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] tri = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };

        List<List<Integer>> triangle = new ArrayList<>();

        for (int[] row : tri) {
            List<Integer> rowList = new ArrayList<>();

            for (int num : row) {
                rowList.add(num);
            }

            triangle.add(rowList);
        }

        int answer = minimumTotal(triangle);

        System.out.println(answer);
    }
}

// class Solution {
// int rows;

// public int minimumTotal(List<List<Integer>> triangle) {
// rows = triangle.size();
// Integer[][] memo = new Integer[rows][];
// for (int i = 0; i < rows; i++) {
// memo[i] = new Integer[i + 1];
// }
// return helper(triangle, 0, 0, memo);
// }

// private int helper(List<List<Integer>> tri, int row, int col, Integer[][]
// memo) {

// if (row == rows - 1) {
// return tri.get(row).get(col);
// }
// if (memo[row][col] != null) {
// return memo[row][col];
// }
// int left = helper(tri, row + 1, col, memo);
// int right = helper(tri, row + 1, col + 1, memo);
// return memo[row][col] = tri.get(row).get(col) + Math.min(left, right);
// }
// }