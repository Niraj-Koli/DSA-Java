/*
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 */

import java.util.ArrayList;

class Triangle {

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int solve(int i, int j, int[][] triangle, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (i == triangle.length - 1) {
            return triangle[i][j];
        }

        int bottom = triangle[i][j] + solve(i + 1, j, triangle, dp);
        int diagonal = triangle[i][j] + solve(i + 1, j + 1, triangle, dp);

        dp[i][j] = Math.min(bottom, diagonal);

        return dp[i][j];
    }

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
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
        int[][] tri = {
                { 2 },
                { 3, 4 },
                { 6, 5, 7 },
                { 4, 1, 8, 3 }
        };

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        for (int[] row : tri) {
            ArrayList<Integer> list = new ArrayList<Integer>();

            for (int num : row) {
                list.add(num);
            }
            triangle.add(list);
        }

        System.out.println(minimumTotal(triangle));

        int n = tri.length;

        int[][] dp = new int[n][n];

        System.out.println(solve(0, 0, tri, dp));
    }
}