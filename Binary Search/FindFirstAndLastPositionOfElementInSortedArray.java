/*
 * Given an array of integers nums sorted in non-decreasing order, find the
 * lefting and righting position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
 */

class FindFirstAndLastPositionOfElementInSortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int firstOccurrence(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = -1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                res = mid;

                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return res;
    }

    private static int lastOccurrence(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = -1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                res = mid;

                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return res;
    }

    private static int[] searchRange(int[] nums, int target) {
        int firstOcc = firstOccurrence(nums, target);
        int lastOcc = lastOccurrence(nums, target);

        return (new int[] { firstOcc, lastOcc });
    }

    private static int countOfAnElement(int[] nums, int target) {
        int firstOcc = firstOccurrence(nums, target);
        int lastOcc = lastOccurrence(nums, target);

        return lastOcc - firstOcc + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] ans = searchRange(nums, target);

        System.out.println("Range: [" + ans[0] + ", " + ans[1] + "]");

        System.out.println("Count: " + countOfAnElement(nums, target));
    }
}