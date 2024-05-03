/*
 * Given a set of N jobs where each jobi has a deadline and profit associated
 * with it.
 * 
 * Each job takes 1 unit of time to complete and only one job can be scheduled
 * at a time. We earn the profit associated with job if and only if the job is
 * completed by its deadline.
 * 
 * Find the number of jobs done and the maximum profit.
 * 
 * Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated
 * with that Job. Deadline of the job is the time before which job needs to be
 * completed to earn the profit.
 */

import java.util.Arrays;

class JobSequencingProblem {
    private static class Job {
        private int deadline;
        private int profit;

        public Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int[] jobScheduling(int n, Job jobs[]) {
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j2.profit, j1.profit));

        int max = Integer.MIN_VALUE;

        for (Job job : jobs) {
            max = Math.max(max, job.deadline);
        }

        int[] slots = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            slots[i] = -1;
        }

        int countJobs = 0;
        int jobsProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = i;
                    countJobs++;
                    jobsProfit += jobs[i].profit;
                    break;
                }
            }
        }

        int[] res = new int[2];
        res[0] = countJobs;
        res[1] = jobsProfit;

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] nums = {
                { 1, 2, 100 }, { 2, 1, 19 }, { 3, 2, 27 },
                { 4, 1, 25 }, { 5, 1, 15 }
        };

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            int deadline = nums[i][1];
            int profit = nums[i][2];

            jobs[i] = new Job(deadline, profit);
        }

        int[] ans = jobScheduling(n, jobs);

        System.out.println(ans[0] + " " + ans[1]);
    }
}