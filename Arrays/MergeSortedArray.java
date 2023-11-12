/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 */

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];

            j++;
        }

        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;

        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

// class Solution {
// public void merge(int[] nums1, int m, int[] nums2, int n) {
// int[] nums1Copy = new int[m];

// for (int idx = 0; idx < m; idx++) {
// nums1Copy[idx] = nums1[idx];
// }

// int nums1CopyPtr = 0, nums2Ptr = 0, sortedPtr = 0;

// while (nums1CopyPtr < m && nums2Ptr < n) {
// if (nums1Copy[nums1CopyPtr] < nums2[nums2Ptr]) {
// nums1[sortedPtr++] = nums1Copy[nums1CopyPtr++];
// } else {
// nums1[sortedPtr++] = nums2[nums2Ptr++];
// }
// }

// while (nums1CopyPtr < m) {
// nums1[sortedPtr++] = nums1Copy[nums1CopyPtr++];
// }

// while (nums2Ptr < n) {
// nums1[sortedPtr++] = nums2[nums2Ptr++];
// }

// }
// }