/*
 * There is an integer array nums sorted in ascrighting order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInRotatedSortedArray {
    public static int binarySearch(int[] nums, int left, int right, int target) {
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

    public static int rotatedValue(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            int next = (middle + 1) % len;
            int prev = (middle + len - 1) % len;

            if (nums[middle] <= nums[next] && nums[middle] <= nums[prev]) {
                return middle;
            } else if (nums[middle] <= nums[right]) {
                right = middle - 1;
            } else if (nums[middle] >= nums[left]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int minimumElementIndex = rotatedValue(nums);

        int firstSearchedElement = binarySearch(nums, 0, minimumElementIndex - 1, target);
        int secondSearchedElement = binarySearch(nums, minimumElementIndex, nums.length - 1, target);

        int result = firstSearchedElement > secondSearchedElement ? firstSearchedElement : secondSearchedElement;

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;

        int answer = search(nums, target);

        System.out.println(answer);
    }
}

// class Solution {
// public int search(int[] a, int target) {
// int i = 0;
// int n = a.length;
// int k = 0;
// int l = 0;
// int h = n - 1;

// while (l <= h) {
// int m = (l + h) / 2;
// if (a[m] > a[n - 1])
// l = m + 1;
// if (a[m] <= a[n - 1]) {
// k = m;
// h = m - 1;
// }
// }

// if (target > a[n - 1]) {
// return bsearch(a, target, 0, k - 1);
// }
// return bsearch(a, target, k, n - 1);
// }

// public static int bsearch(int[] a, int target, int low, int high) {

// while (low <= high) {
// int mid = (low + high) / 2;
// if (a[mid] == target)
// return mid;
// if (a[mid] < target) {
// low = mid + 1;
// }
// if (a[mid] > target) {
// high = mid - 1;
// }

// }
// return -1;
// }
// }