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

public class MaximumProfitInJobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

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

        int ans = jobScheduling(startTime, endTime, profit);

        System.out.println(ans);
    }
}

// class Solution {
// class Job {
// int start;
// int end;
// int profit;

// public Job(int start, int end, int profit) {
// this.start = start;
// this.end = end;
// this.profit = profit;
// }
// }

// private static int compareJobs(Job m, Job n) {
// return Integer.compare(m.end, n.end);
// }

// public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
// int n = startTime.length;
// int[] dp = new int[n];
// Job[] jobs = new Job[n];

// for (int i = 0; i < n; i++) {
// jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
// }

// Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

// dp[0] = jobs[0].profit;

// for (int i = 1; i < n; i++) {
// int prev = 0;
// for (int j = i - 1; j >= 0; j--) {
// if (jobs[i].start >= jobs[j].end) {
// prev = dp[j];
// break;
// }
// }
// dp[i] = Math.max(prev + jobs[i].profit, dp[i - 1]);
// }
// return dp[n - 1];
// }
// }