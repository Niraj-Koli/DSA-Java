/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 */

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums = new int[m + n];

        int k = 0;

        for (int i = 0; i < n; i++) {
            nums[k] = nums1[i];
            k++;
        }

        for (int i = 0; i < m; i++) {
            nums[k] = nums2[i];
            k++;
        }

        Arrays.sort(nums);

        int len = nums.length;

        int left = 0;
        int right = len - 1;

        int middle = left + (right - left) / 2;

        if (len % 2 == 0) {
            return (double) (nums[middle] + nums[middle + 1]) / 2;
        } else {
            return (double) nums[middle];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        double answer = findMedianSortedArrays(nums1, nums2);

        System.out.println(answer);
    }
}

// class Solution {
// public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// int n = nums1.length;
// int m = nums2.length;

// int[] helper = new int[m + n];

// int i = 0, p1 = 0, p2 = 0;

// while (p1 < nums1.length && p2 < nums2.length) {
// helper[i++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
// }

// while (p1 < nums1.length) {
// helper[i++] = nums1[p1++];
// }

// while (p2 < nums2.length) {
// helper[i++] = nums2[p2++];
// }

// if (helper.length % 2 == 0) {
// return (double) (helper[(n + m) / 2 - 1] + helper[(n + m) / 2]) / 2;
// }

// return (double) helper[(n + m) / 2];
// }
// }