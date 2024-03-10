/*
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The
 * stalls are located along a straight line at positions x1 ... xN (0 <= xi <=
 * 1,000,000,000).
 * 
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive
 * towards each other once put into a stall. To prevent the cows from hurting
 * each other, FJ wants to assign the cows to the stalls, such that the minimum
 * distance between any two of them is as large as possible. What is the largest
 * minimum distance?
 */

import java.util.Arrays;

public class AggressiveCows {

    // Time -> O((n * log(n)) + (n * log(max - min)))
    // Space -> O(1)

    private static boolean cowsPlaced(int[] stalls, int k, int dist) {
        int n = stalls.length;

        int cows = 1;
        int last = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cows++;
                last = stalls[i];
            }

            if (cows >= k) {
                return true;
            }
        }

        return false;
    }

    private static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int n = stalls.length;

        int left = 1;
        int right = stalls[n - 1] - stalls[0];

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (cowsPlaced(stalls, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] stalls = { 0, 3, 4, 7, 10, 9 };
        int k = 4;

        System.out.println(aggressiveCows(stalls, k));
    }
}