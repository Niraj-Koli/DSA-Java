/*
 * You are given an n x m integer matrix matrix with the following two
 * properties:
 * 
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * Given an integer target, return true if target is in matrix or false
 * otherwise.
 * 
 * You must write a solution in O(log(n * m)) time complexity.
 */

class SearchA2DMatrix {

    // Time -> O(n * log(m)) //
    // Space -> O(1) //

    private static boolean binarySearch(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;

        for (int i = 0; i < n; i++) {
            if (matrix[i][left] <= target && matrix[i][right] >= target) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}