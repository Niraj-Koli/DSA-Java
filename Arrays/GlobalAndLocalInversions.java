/*
 * You are given an integer array nums of length n which represents a
 * permutation of all the integers in the range [0, n - 1].
 * 
 * The number of global inversions is the number of the different pairs (i, j)
 * where:
 * 
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * The number of local inversions is the number of indices i where:
 * 
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * Return true if the number of global inversions is equal to the number of
 * local inversions.
 */

import java.util.ArrayList;

public class GlobalAndLocalInversions {

    // Time -> O(n log(n))
    // Space -> O(n)

    private static int merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int left = low;
        int right = mid + 1;

        int count = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                count += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return count;
    }

    private static int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += merge(nums, low, mid, high);

        return count;
    }

    private static int getLocalInversions(int[] nums, int n) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        return count;
    }

    private static boolean isIdealPermutation(int[] nums) {
        int n = nums.length;

        int localInversions = getLocalInversions(nums, n);
        int globalInversions = mergeSort(nums, 0, n - 1);

        return globalInversions == localInversions;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2 };

        System.out.println(isIdealPermutation(nums));
    }
}