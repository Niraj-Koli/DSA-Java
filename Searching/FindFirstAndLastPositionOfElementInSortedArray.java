/*
 * Given an array of integers nums sorted in non-decreasing order, find the
 * lefting and righting position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
 */

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int firstOccurrence(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                result = middle;

                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return result;
    }

    public static int lastOccurrence(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                result = middle;

                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstPosition = firstOccurrence(nums, target);
        int lastPosition = lastOccurrence(nums, target);

        return (new int[] { firstPosition, lastPosition });
    }

    public static int countOfAnElement(int[] nums, int target) {
        int firstPosition = firstOccurrence(nums, target);
        int lastPosition = lastOccurrence(nums, target);

        return lastPosition - firstPosition + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] answer = searchRange(nums, target);
        int counter = countOfAnElement(nums, target);

        System.out.println("Range: " + Arrays.toString(answer));
        System.out.println("Count: " + counter);
    }
}

// class Solution {
// public int[] searchRange(int[] nums, int target) {
// int l = 0, h = nums.length - 1, mid = 0;
// int res[] = { -1, -1 };
// while (l <= h) {
// mid = (l + h) / 2;
// if (target == nums[mid]) {
// res[0] = mid;
// h = mid - 1;
// } else if (nums[mid] < target) {
// l = mid + 1;

// } else {
// h = mid - 1;
// }

// }
// l = 0;
// h = nums.length - 1;
// mid = 0;
// while (l <= h) {
// mid = (l + h) / 2;
// if (target == nums[mid]) {
// res[1] = mid;
// l = mid + 1;
// } else if (nums[mid] < target) {
// l = mid + 1;
// } else {
// h = mid - 1;
// }

// }
// return res;
// }
// }