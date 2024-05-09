/*
 * Given an array of integers nums which is sorted in ascrighting order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */

class BinarySearch {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

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

    private static int ascendingbinarySearch(int[] nums, int left, int right, int target) {
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

    private static int descendingbinarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 5, 7, 8 };
        int target = 7;

        System.out.println(search(nums, target));
        
        System.out.println(ascendingbinarySearch(nums, 0, nums.length - 1, target));

        int[] smun = { 8, 7, 5, 3, 0 };

        System.out.println(descendingbinarySearch(smun, 0, smun.length - 1, target));
    }
}