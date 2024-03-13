/*
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that
 * no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same
 * day. Arrival and departure time can never be the same for a train but we can
 * have arrival time of one train equal to departure time of the other. At any
 * given instance of time, same platform can not be used for both departure of a
 * train and arrival of another train. In such cases, we need different
 * platforms.
 */

import java.util.Arrays;

public class MinimumPlatforms {

    // Time -> O(n * log(n))
    // Space -> O(1)

    private static int findPlatform(int n, int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int res = 1;

        for (int i = 1, j = 0; i < n; i++) {
            if (departure[j] < arrival[i]) {
                j++;
            } else if (departure[j] >= arrival[i]) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(n, arrival, departure));
    }
}