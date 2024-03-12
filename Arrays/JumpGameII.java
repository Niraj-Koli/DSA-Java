/*
 * You are given a 0-indexed array of integers nums of length n. You are
 * initially positioned at nums[0].
 * 
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
 * j] where:
 * 
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 */

public class JumpGameII {

    // Time -> O(n)
    // Space -> O(1)

    private static int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int currentIntervalEnd = 0;
        int nextIntervalEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            nextIntervalEnd = Math.max(nextIntervalEnd, i + nums[i]);
            if (i == currentIntervalEnd) {
                currentIntervalEnd = nextIntervalEnd;
                jumps++;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(jump(nums));
    }
}