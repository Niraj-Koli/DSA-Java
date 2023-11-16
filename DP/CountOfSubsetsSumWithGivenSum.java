/*
 * Given an array arr[] of length N and an integer X, the task is to find the
 * number of subsets with sum equal to X.
 */

public class CountOfSubsetsSumWithGivenSum {
    public static int countOfSubsetsSum(int[] nums, int sum) {
        int n = nums.length;

        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            t[0][i] = 0;
        }

        for (int j = 0; j < n + 1; j++) {
            t[j][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;

        int answer = countOfSubsetsSum(nums, sum);

        System.out.println(answer);

    }
}