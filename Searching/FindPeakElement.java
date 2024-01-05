/*
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 */

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle > 0 && middle < n - 1) {
                if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                    return middle;
                } else if (nums[middle - 1] < nums[middle]) {
                    left = middle + 1;
                } else if (nums[middle - 1] > nums[middle]) {
                    right = middle - 1;
                }
            } else if (middle == 0) {
                if (nums[middle] > nums[middle + 1]) {
                    return middle;
                } else {
                    return middle + 1;
                }
            } else if (middle == n - 1) {
                if (nums[middle] > nums[middle - 2]) {
                    return middle;
                } else {
                    return middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 31, 321, 23 };

        int answer = findPeakElement(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int findPeakElement(int[] arr) {
// int start = 0;
// int end = arr.length - 1;
// while (start < end) {
// int mid = start + (end - start) / 2;
// if (arr[mid] > arr[mid + 1]) {
// // we are in the descendingly sorted part of the array
// // this may be the answer, but its left part may contain the answer too
// // that is why we set end = mid
// end = mid;
// } else {
// // we are in the ascendingly sorted part of the array
// // the answer will always be on the right side of the mid
// // as this is in ascending order
// // that is why we take start = mid + 1
// start = mid + 1;
// }
// }
// // in the end, both the start and the end pointers will point to the same
// // element
// return start; // or end
// }
// }