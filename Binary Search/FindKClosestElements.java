/*
 * Given a sorted integer array nums, two integers k and x, return the k closest
 * integers to x in the array. The res should also be sorted in ascending
 * order.
 * 
 * An integer a is closer to x than an integer b if:
 * 
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */

import java.util.ArrayList;

class FindKClosestElements {

    // Time -> O(n + log(n)) //
    // Space -> O(n) //

    private static ArrayList<Integer> findClosestElements(int[] nums, int k, int x) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (right - left >= k) {
            if (Math.abs(nums[left] - x) > Math.abs(nums[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        ArrayList<Integer> res = new ArrayList<>(k);

        for (int i = left; i <= right; i++) {
            res.add(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(nums, k, x));
    }
}