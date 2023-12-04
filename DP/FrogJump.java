/*
 * Given a number of stairs and a frog, the frog wants to climb from the 0th
 * stair to the (N-1)th stair. At a time the frog can climb either one or two
 * steps. A height[N] array is also given. Whenever the frog jumps from a stair
 * i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
 * where abs() means the absolute difference. We need to return the minimum
 * energy that can be used by the frog to jump from stair 0 to stair N-1.
 */

public class FrogJump {
    public static int[] dp = new int[100000];

    public static int solve(int i, int[] height) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != 0)
            return dp[i];

        int jumpOne = solve(i - 1, height) + Math.abs(height[i] - height[i - 1]);

        int jumpTwo = i > 1 ? solve(i - 2, height) + Math.abs(height[i] - height[i - 2]) : Integer.MAX_VALUE;

        dp[i] = Math.min(jumpOne, jumpTwo);

        return dp[i];
    }

    public static int frogJump(int[] heights) {
        int n = heights.length;

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {

            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            int jumpTwo = i > 1 ? dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };

        int answer = frogJump(heights);

        System.out.println(answer);
    }
}