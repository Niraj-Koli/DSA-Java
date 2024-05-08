/*
 * The next greater element of some element x in an array is the first greater
 * element that is to the right of x in the same array.
 * 
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where
 * nums1 is a subset of nums2.
 * 
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
 * nums2[j] and determine the next greater element of nums2[j] in nums2. If
 * there is no next greater element, then the answer for this query is -1.
 * 
 * Return an array ans of length nums1.length such that ans[i] is the next
 * greater element as described above.
 */

import java.util.ArrayDeque;
import java.util.HashMap;

class NextGreaterElementI {

    // Time -> O(n + m) //
    // Space -> O(n) //

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.pollLast(), nums2[i]);
            }
            stack.offer(nums2[i]);
        }

        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] ans = nextGreaterElement(nums1, nums2);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}