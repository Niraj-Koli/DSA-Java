/*
 * Given a row-wise sorted matrix of size r*c, where r is no. of rows and c is
 * no. of columns, find the median in the given matrix.
 */

public class MedianOfRowWiseSortedMatrix {

    // Time -> O(n * log(m))
    // Space -> O(1)

    private static int countSmallerThanMid(int[] nums, int mid) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (nums[middle] <= mid) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private static int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 1;
        int high = 1000000000;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            int count = 0;

            for (int i = 0; i < n; i++) {
                count += countSmallerThanMid(matrix[i], mid);
            }

            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 8 },
                { 2, 3, 4 },
                { 1, 2, 5 }
        };

        System.out.println(findMedian(matrix));
    }
}