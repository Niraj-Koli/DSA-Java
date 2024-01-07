/*
 * Given an array containing infinite sorted integers and an element, write a
 * program to find the position of the element.
 */

public class SearchInAnInfiniteSortedArray {
    public static int infiniteElement(int[] nums, int target) {
        int left = 0;
        int right = 1;

        while (target > nums[right]) {
            left = right;
            right = right * 2;
        }

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

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 7;

        int answer = infiniteElement(nums, target);

        System.out.println(answer);
    }
}