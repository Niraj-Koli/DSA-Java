/*
 * Given an array containing infinite sorted integers and an element, write a
 * program to find the position of the element.
 */

class SearchInAnInfiniteSortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int infiniteElement(int[] nums, int target) {
        int left = 0;
        int right = 1;

        while (target > nums[right]) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 7;

        System.out.println(infiniteElement(nums, target));
    }
}