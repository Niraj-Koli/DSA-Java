/*
 * Given an unsorted array of size n. Array elements are in the range of 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the
 * array. Find these two numbers.
 */

import java.util.ArrayList;

public class MissingAndRepeatingNumber {
    public static void swapSort(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 6, 1, 3, 4, 8 };

        swapSort(nums);

        int n = nums.length;

        ArrayList<Integer> missingNums = new ArrayList<Integer>();
        ArrayList<Integer> repeatingNums = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                missingNums.add(i + 1);
                repeatingNums.add(nums[i]);
            }
        }

        System.out.println(missingNums);
        System.out.println(repeatingNums);
    }
}