/*
 * You are given a rows x cols matrix grid representing a field of cherries
 * where grid[i][j] represents the number of cherries that you can collect from
 * the (i, j) cell.
 * 
 * You have two robots that can collect cherries for you:
 * 
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by
 * following the rules below:
 * 
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i
 * + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries, and the cell
 * becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 */

public class CherryPickupII {
    public static int[][][] t = new int[100000][100000][100000];

    static int solve(int i, int j1, int j2, int n, int m, int[][] grid) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) (Math.pow(-10, 9));
        }

        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (t[i][j1][j2] != 0) {
            return t[i][j1][j2];
        }

        int max = Integer.MIN_VALUE;

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2) {
                    ans = grid[i][j1] + solve(i + 1, j1 + di, j2 + dj, n, m, grid);
                } else {
                    ans = grid[i][j1] + grid[i][j2] + solve(i + 1, j1 + di, j2 + dj, n, m, grid);
                }

                max = Math.max(max, ans);
            }
        }
        return t[i][j1][j2] = max;
    }

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int t[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    t[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    t[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2) {
                                ans = grid[i][j1];
                            } else {
                                ans = grid[i][j1] + grid[i][j2];
                            }

                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m)) {
                                ans += (int) Math.pow(-10, 9);
                            } else {
                                ans += t[i + 1][j1 + di][j2 + dj];
                            }

                            max = Math.max(ans, max);
                        }
                    }

                    t[i][j1][j2] = max;
                }
            }
        }

        return t[0][0][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };

        int answer = cherryPickup(grid);

        System.out.println(answer);
    }
}

// class Solution {
// int cur[][][];

// public int cherryPickup(int[][] grid) {
// int n = grid[0].length;
// int[][] cur = new int[n][n], prev = new int[n][n];
// for (int r = grid.length - 1; r >= 0; r--) {
// for (int c1 = Math.min(r, n - 1); c1 >= 0; c1--) {
// for (int c2 = Math.max(c1, n - 1 - r); c2 < n; c2++) {
// int max = 0;
// for (int i = c1 - 1; i <= c1 + 1; i++) {
// for (int j = c2 - 1; j <= c2 + 1; j++) {
// if (i >= 0 && i < n && j >= 0 && j < n && i <= j)
// max = Math.max(max, prev[i][j]);
// }
// }
// cur[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
// }
// }
// int[][] temp = cur;
// cur = prev;
// prev = temp;
// }
// return prev[0][n - 1];
// }
// }