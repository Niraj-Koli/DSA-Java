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

class CeilAndFloorOfAnSortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int ceilElement(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = -1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                res = nums[mid];

                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return res;
    }

    private static int floorElement(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                res = nums[mid];

                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 8, 10, 10, 12, 19 };
        int target = 5;

        int ceil = ceilElement(nums, target);
        int floor = floorElement(nums, target);

        System.out.println("[" + floor + ", " + ceil + "]");
    }
}