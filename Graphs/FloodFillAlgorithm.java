/*
 * An image is represented by an m ncol n integer grid image where image[i][j]
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

class FloodFillAlgorithm {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static void dfs(int[][] image, int[][] res, int row, int col, int color, int[] dx, int[] dy,
            int initColor) {
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

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
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

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}