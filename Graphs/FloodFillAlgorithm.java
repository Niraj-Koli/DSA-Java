/*
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and color. You should perform a
 * flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with color.
 * 
 * Return the modified image after performing the flood fill.
 */

// Time -> O(N x M)
// Space -> O(N x M)

public class FloodFillAlgorithm {
    public static void dfs(int[][] image, int[][] res, int row, int col, int color, int[] dx, int[] dy, int initColor) {
        int n = image.length;
        int m = image[0].length;

        res[row][col] = color;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

            if (bounds && image[nrow][ncol] == initColor && res[nrow][ncol] != color) {
                dfs(image, res, nrow, ncol, color, dx, dy, initColor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];

        int[][] res = image;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        dfs(image, res, sr, sc, color, dx, dy, initColor);

        return res;
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] ans = floodFill(image, sr, sc, color);

        for (int[] answer : ans) {
            for (int a : answer) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

// int color = image[sr][sc];

// if (color != newColor) {
// floodFillRecursive(image, sr, sc, color, newColor);
// }
// return image;
// }

// private void floodFillRecursive(int[][] image, int sr, int sc, int color, int
// newColor) {

// color
// if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ||
// image[sr][sc] != color) {
// return;
// }

// image[sr][sc] = newColor;
// floodFillRecursive(image, sr - 1, sc, color, newColor); // Up
// floodFillRecursive(image, sr + 1, sc, color, newColor); // Down
// floodFillRecursive(image, sr, sc - 1, color, newColor); // Left
// floodFillRecursive(image, sr, sc + 1, color, newColor); // Right
// }
// }

// class Solution {
// class Pair {
// int row;
// int col;

// Pair(int _r, int _c) {
// this.row = _r;
// this.col = _c;
// }
// }

// public int[][] floodFill(int[][] image, int sr, int sc, int color) {
// int n = image.length;
// int m = image[0].length;
// int[][] flood = new int[n][m];
// int toBePainted = image[sr][sc];

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// flood[i][j] = image[i][j];
// }
// }

// int[][] visited = new int[n][m];
// Queue<Pair> q = new LinkedList<>();
// q.offer(new Pair(sr, sc));
// visited[sr][sc] = 1;

// int[] dx = { -1, +1, 0, 0 };
// int[] dy = { 0, 0, +1, -1 };
// while (!q.isEmpty()) {
// Pair p = q.poll();
// flood[p.row][p.col] = color;
// for (int i = 0; i < 4; i++) {
// int dRow = p.row + dx[i];
// int dCol = p.col + dy[i];

// if (dRow >= 0 && dCol >= 0 &&
// dRow < n && dCol < m &&
// visited[dRow][dCol] == 0 &&
// image[dRow][dCol] == toBePainted) {
// q.offer(new Pair(dRow, dCol));
// visited[dRow][dCol] = 1;
// }
// }

// }
// return flood;

// }
// }