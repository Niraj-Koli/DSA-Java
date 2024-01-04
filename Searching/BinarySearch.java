/*
 * Given an array of integers nums which is sorted in ascrighting order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static int ascendingbinarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static int descendingbinarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                left = middle + 1;
            } else if (nums[middle] < target) {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 5, 7, 8 };
        int target = 7;

        int answer = search(nums, target);

        System.out.println(answer);
    }
}

// class Solution {
// public int search(int[] nums, int target) {
// int lower = 0;
// int upper = nums.length - 1;
// int pos = (lower + upper) / 2;

// while (lower <= upper) {
// if (nums[pos] == target) {
// return pos;
// } else if (nums[pos] > target) {
// upper = pos - 1;
// } else {
// lower = pos + 1;
// }

// pos = (lower + upper) / 2;
// System.gc();
// }

// return -1;
// }
// }