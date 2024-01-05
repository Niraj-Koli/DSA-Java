/*
 * Suppose an array of length n sorted in ascrighting order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum
 * element of this array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 */

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            int next = (middle + 1) % n;
            int prev = (middle + n - 1) % n;

            if (nums[prev] >= nums[middle] && nums[next] >= nums[middle]) {
                return nums[middle];
            } else if (nums[middle] <= nums[right]) {
                right = middle - 1;
            } else if (nums[middle] >= nums[left]) {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        int answer = findMin(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int findMin(int[] nums) {
// int left = 0, right = nums.length - 1;

// while (left < right) {
// int middle = left + (right - left) / 2;

// if (nums[middle] < nums[right])
// right = middle;
// else
// left = middle + 1;
// }

// return nums[left];
// }
// }