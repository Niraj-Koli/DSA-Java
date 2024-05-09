/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to
 * endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime, endTime and profit arrays, return the maximum
 * profit you can take such that there are no two jobs in the subset with
 * overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job
 * that starts at time X.
 */

import java.util.Arrays;
import java.util.TreeMap;

class MaximumProfitInJobScheduling {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();

        dp.put(0, 0);

        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];

            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }

        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] startTime = { 1, 2, 3, 3 };
        int[] endTime = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };

        System.out.println(jobScheduling(startTime, endTime, profit));
    }
}