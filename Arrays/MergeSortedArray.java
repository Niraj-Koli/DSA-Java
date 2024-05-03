/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers n and m, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of n +
 * m, where the first n elements denote the elements that should be merged, and
 * the last m elements are set to 0 and should be ignored. nums2 has a length of
 * m.
 */

class MergeSortedArray {

    // Time -> O(m + n) //
    // Space -> O(1) //

    private static void merge(int[] nums1, int n, int[] nums2, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int n = 3;

        int[] nums2 = { 2, 5, 6 };
        int m = 3;

        merge(nums1, n, nums2, m);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}