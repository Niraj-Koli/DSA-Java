public class CountingSort {

    // Time -> O(n + k) //
    // Space -> O(k) //

    public static void countingSort(int[] arr, int maxValue) {
        int n = arr.length;

        int[] count = new int[maxValue + 1];
        int[] output = new int[n];

        for (int i = 0; i <= maxValue; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };
        int max = 91;

        countingSort(nums, max);

        for (int number : nums) {
            System.out.print(number + " ");
        }
    }
}

// class Solution {
// public int[] sortArray(int[] nums) {
// int min = Integer.MAX_VALUE;
// int max = Integer.MIN_VALUE;

// for (int num : nums) {
// if (num < min) {
// min = num;
// }
// if (num > max) {
// max = num;
// }
// }

// int SHIFT = min * -1;
// int MAX = max + SHIFT + 1;

// int[] counts = new int[MAX];
// for (int num : nums) {
// int idx = num + SHIFT;
// counts[idx]++;
// }

// int writer = 0;
// int lowerBound = min + SHIFT;
// int upperBound = max + SHIFT;
// for (int i = lowerBound; i <= upperBound; i++) {
// while (counts[i]-- > 0) {
// nums[writer++] = i - SHIFT;
// }
// }
// return nums;
// }
// }