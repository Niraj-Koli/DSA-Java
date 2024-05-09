/*
 * Given an array/list of length ‘N’, where the array/list represents the boards
 * and each element of the given array/list represents the length of each board.
 * Some ‘K’ numbers of painters are available to paint these boards. Consider
 * that each unit of a board takes 1 unit of time to paint. You are supposed to
 * return the area of the minimum time to get this job done of painting all the
 * ‘N’ boards under the constraint that any painter will only paint the
 * continuous sections of boards.
 */

class PaintersPartition {

    // Time -> O(n * log(sum - max + 1)) //
    // Space -> O(1) //

    private static int countPainters(int[] boards, int maxSum) {
        int n = boards.length;

        int painters = 1;
        int boardPainted = 0;

        for (int i = 0; i < n; i++) {
            if (boardPainted + boards[i] > maxSum) {
                painters++;
                boardPainted = 0;
            }

            boardPainted += boards[i];
        }

        return painters;
    }

    private static int findLargestMinDistance(int[] boards, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int num : boards) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int painters = countPainters(boards, mid);

            if (painters <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] boards = { 10, 20, 30, 40 };
        int k = 2;

        System.out.println(findLargestMinDistance(boards, k));
    }
}