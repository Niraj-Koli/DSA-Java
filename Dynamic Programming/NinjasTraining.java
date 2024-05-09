/*
 * A Ninja has an ‘N’ Day training schedule. He has to perform one of these
 * three activities (Running, Fighting Practice, or Learning New Moves) each
 * day. There are merit points associated with performing an activity each day.
 * The same activity can’t be performed on two consecutive days. We need to find
 * the maximum merit points the ninja can attain in N Days.
 * 
 * We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point
 * of specific activity on that particular day. Our task is to calculate the
 * maximum number of merit points that the ninja can earn.
 */

class NinjasTraining {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int solve(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != 0) {
            return dp[day][last];
        }

        if (day == 0) {
            int max = 0;

            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }

            dp[day][last] = max;

            return dp[day][last];
        }

        int max = 0;

        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + solve(day - 1, i, points, dp);
                max = Math.max(max, activity);
            }
        }

        dp[day][last] = max;

        return dp[day][last];
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int ninjaTraining(int[][] points) {
        int n = points.length;

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        int[][] points = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };

        System.out.println(ninjaTraining(points));

        int n = points.length;

        int[][] dp = new int[n][4];

        System.out.println(solve(n - 1, 3, points, dp));
    }
}