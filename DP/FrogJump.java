/*
 * Given a number of stairs and a frog, the frog wants to climb from the 0th
 * stair to the (N-1)th stair. At a time the frog can climb either one or two
 * steps. A height[N] array is also given. Whenever the frog jumps from a stair
 * i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
 * where abs() means the absolute difference. We need to return the minimum
 * energy that can be used by the frog to jump from stair 0 to stair N-1.
 */

public class FrogJump {
    public static int frogJump(int[] heights) {
        int n = heights.length;

        int[] t = new int[n];

        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;

            int jumpOne = t[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            if (i > 1) {
                jumpTwo = t[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            t[i] = Math.min(jumpOne, jumpTwo);
        }

        return t[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };

        int answer = frogJump(heights);

        System.out.println(answer);
    }
}