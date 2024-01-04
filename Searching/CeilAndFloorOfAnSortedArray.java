/*
 * Given a sorted array and a value x, the ceiling of x is the smallest element
 * in an array greater than or equal to x, and the floor is the greatest element
 * smaller than or equal to x. Assume that the array is sorted in non-decreasing
 * order. Write efficient functions to find the floor and ceiling of x.
 * 
 * Given a sorted array and a value x, the floor of x is the largest element in
 * the array smaller than or equal to x. Write efficient functions to find the
 * floor of x
 */

public class CeilAndFloorOfAnSortedArray {
    public static int ceilElement(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return nums[middle];
            } else if (nums[middle] > target) {
                result = nums[middle];

                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return result;
    }

    public static int floorElement(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return nums[middle];
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                result = nums[middle];

                left = middle + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 8, 10, 10, 12, 19 };
        int target = 5;

        int ceil = ceilElement(nums, target);
        int floor = floorElement(nums, target);

        System.out.println("[" + floor + ", " + ceil + "]");
    }
}