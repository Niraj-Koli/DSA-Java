/*
 * There are several cards arranged in a row, and each card has an associated
 * number of points. The points are given in the integer array cardPoints.
 * 
 * In one step, you can take one card from the beginning or from the end of the
 * row. You have to take exactly k cards.
 * 
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum
 * score you can obtain.
 */

public class MaximumPointsYouCanObtainFromCards {

    // Time -> O(n)
    // Space -> O(1)

    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int total = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < n; j++) {
            total += cardPoints[j];
            sum += cardPoints[j];

            if (j - i + 1 == n - k) {
                min = Math.min(min, sum);

                sum -= cardPoints[i];
                i++;
            }
        }

        return total - (min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void main(String[] args) {
        int[] cardPoints = { 9, 7, 7, 9, 7, 7, 9 };
        int k = 7;

        System.out.println(maxScore(cardPoints, k));
    }
}