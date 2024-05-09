/*
 * A peak element in a 2D grid is an element that is strictly greater than all
 * of its adjacent neighbors to the left, right, top, and bottom.
 * 
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal,
 * find any peak element mat[i][j] and return the length 2 array [i,j].
 * 
 * You may assume that the entire matrix is surrounded by an outer perimeter
 * with the value -1 in each cell.
 * 
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 */

class FindAPeakElementII {

    // Time -> O(n * log(m)) //
    // Space -> O(1) //

    private static int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int max_row = 0;

            for (int i = 0; i < n; i++) {
                if (matrix[max_row][mid] < matrix[i][mid]) {
                    max_row = i;
                }
            }
            
            if ((mid == 0 || matrix[max_row][mid] > matrix[max_row][mid - 1]) &&
                    (mid == m - 1 || matrix[max_row][mid] > matrix[max_row][mid + 1])) {
                return new int[] { max_row, mid };
            } else if (mid > 0 && matrix[max_row][mid - 1] > matrix[max_row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 15 },
                { 21, 30, 14 },
                { 7, 16, 32 },
        };

        int[] ans = findPeakGrid(matrix);

        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }
}