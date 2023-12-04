/* There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is hi.

There is a frog who is initially on Stone 1. He will repeat the following action some number of timesto reach Stone N:
If the frog is currently on Stone i, jump to one of the following: Stone i+1,i+2,…,i+K. Here, a cost of ∣h i−h j ∣ is incurred, where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N. */

public class FrogJumpII {
    public static int[] dp = new int[100000];

    static int solveUtil(int i, int[] height, int k) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int mmSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int jump = solveUtil(i - j, height, k) + Math.abs(height[i] - height[i - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }

        return dp[i] = mmSteps;
    }

    public static int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);

                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int k = 2;

        int answer = frogJump(heights, k);

        System.out.println(answer);
    }
}