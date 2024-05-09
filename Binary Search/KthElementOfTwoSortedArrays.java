/*
 * You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm'
 * respectively and an element 'k'.
 * 
 * Find the element that would be at the 'kth' position of the combined sorted
 * array.
 * 
 * Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and
 * 'arr2' are using 0 - based indexing.
 */

class KthElementOfTwoSortedArrays {

    // Time -> O(log(min(n, m))) //
    // Space -> O(1) //

    private static int kthElement(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return kthElement(nums2, nums1, k);
        }

        int left = Math.max(0, k - n);
        int right = Math.min(k, m);

        while (left <= right) {
            int mid1 = left + ((right - left) / 2);
            int mid2 = k - mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 6, 7, 9 };
        int[] nums2 = { 1, 4, 8, 10 };
        int k = 5;

        System.out.println(kthElement(nums1, nums2, k));
    }
}