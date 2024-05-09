/*
 * You are given an integer array bloomDay, an integer m and an integer k.
 * 
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 */

class MinimumNumberOfDaysToMakeMBouquets {

    // Time -> O(n * log(max)) //
    // Space -> O(1) //

    private static int bouquetMadeAfterMidDay(int[] bloomDay, int k, int day) {
        int n = bloomDay.length;

        int bouquets = 0;
        int flowers = 0;

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }

        return bouquets;
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int bloom : bloomDay) {
            max = Math.max(max, bloom);
            min = Math.min(min, bloom);
        }

        int left = min;
        int right = max;

        int res = -1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int bouquets = bouquetMadeAfterMidDay(bloomDay, k, mid);

            if (bouquets >= m) {
                res = mid;

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2;
        int k = 3;

        System.out.println(minDays(bloomDay, m, k));
    }
}