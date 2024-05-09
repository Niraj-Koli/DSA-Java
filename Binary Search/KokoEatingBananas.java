/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 */

class KokoEatingBananas {

    // Time -> O(n * log(max)) //
    // Space -> O(1) //

    private static int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }

    private static int totalHours(int[] piles, int hourly) {
        int n = piles.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            total += Math.ceil((double) piles[i] / (double) hourly);
        }

        return total;
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int hours = totalHours(piles, mid);

            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 6;

        System.out.println(minEatingSpeed(piles, h));
    }
}