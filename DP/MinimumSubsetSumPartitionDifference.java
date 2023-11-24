/*
 * Given an array arr of size n containing non-negative integers, the task is to
 * divide it into two sets S1 and S2 such that the absolute difference between
 * their sums is minimum and find the minimum difference
 */

public class MinimumSubsetSumPartitionDifference {
    public static int minDifference(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            t[0][i] = false;
        }

        for (int j = 0; j < n + 1; j++) {
            t[j][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = sum / 2; j >= 0; j--) {
            if (t[n][j] == true) {
                min = sum - 2 * j;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 6, 6, 5, 7, 4, 7, 6};

        int answer = minDifference(nums);

        System.out.println(answer);
    }
}