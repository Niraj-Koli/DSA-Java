/*
 * Given two sorted arrays, ‘a’ and ‘b’, of size ‘n’ and ‘m’, respectively,
 * return the union of the arrays.
 * 
 * The union of two sorted arrays can be defined as an array consisting of the
 * common and the distinct elements of the two arrays. The final array should be
 * sorted in ascending order.
 * 
 * Note: 'a' and 'b' may contain duplicate elements, but the union array must
 * contain unique elements.
 */

import java.util.ArrayList;
import java.util.TreeSet;

class UnionOfTwoSortedArrays {

    // Time -> O((n + m) * size) //
    // Space -> O(n + m + size) //

    private static ArrayList<Integer> findUnion(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            set.add(num);
        }

        ArrayList<Integer> union = new ArrayList<Integer>();

        for (int element : set) {
            union.add(element);
        }

        return union;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 2, 3, 5 };

        System.out.println(findUnion(nums1, nums2));
    }
}