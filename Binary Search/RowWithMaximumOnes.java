/*
 * You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns
 * consisting of only 0s and 1s. All the rows are sorted in ascending order.
 * 
 * Your task is to find the index of the row with the maximum number of ones.
 * 
 * Note: If two rows have the same number of ones, consider the one with a
 * smaller index. If there's no row with at least 1 zero, return -1.
 */

class RowWithMaximumOnes {

    // Time -> O(n * log(m)) //
    // Space -> O(1) //

    private static int binarySearch(int[] nums, int m) {
        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int rowMaxOnes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int res = -1;
        int maxOnes = 0;

        for (int i = 0; i < n; i++) {

            int rowOnes = m - binarySearch(matrix[i], m);

            if (rowOnes > maxOnes) {
                maxOnes = rowOnes;
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 },
        };

        System.out.println(rowMaxOnes(matrix));
    }
}