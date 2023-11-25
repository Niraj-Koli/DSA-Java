/*
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 */

public class HouseRobber {
    public static int[] t = new int[100000];

    static int solve(int i, int[] nums) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return nums[i];
        }

        if (t[i] != 0) {
            return t[i];
        }

        int pick = nums[i] + solve(i - 2, nums);
        int nonPick = solve(i - 1, nums);

        t[i] = Math.max(pick, nonPick);

        return t[i];
    }

    public static int rob(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];

        t[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];

            if (i > 1) {
                pick += t[i - 2];
            }

            int nonPick = t[i - 1];

            t[i] = Math.max(pick, nonPick);
        }

        return t[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };

        int answer = rob(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int rob(int[] nums) {
// if (nums.length < 2) {
// return nums[0];
// }
// int rob1 = nums[0];
// int rob2 = Math.max(nums[0], nums[1]);
// int max_rob;
// for (int i = 2; i < nums.length; i++) {
// {
// max_rob = Math.max(rob1 + nums[i], rob2);
// rob1 = rob2;
// rob2 = max_rob;
// }
// }
// return rob2;
// }
// }