/*
 * Given a bitonic sequence of n distinct elements, and an integer x, the task
 * is to write a program to find given element x in the bitonic sequence in
 * O(log n) time.
 */

class SearchAnElementInABitonicArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] < nums[mid]) {
                    left = mid + 1;
                } else if (nums[mid - 1] > nums[mid]) {
                    right = mid - 1;
                }
            } else if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            } else if (mid == n - 1) {
                if (nums[mid] > nums[mid - 2]) {
                    return mid;
                } else {
                    return mid - 1;
                }
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

    private static int bitonicElement(int[] nums, int target) {
        int n = nums.length;

        int peak = findPeakElement(nums);

        int first = ascendingbinarySearch(nums, 0, peak - 1, target);
        int second = descendingbinarySearch(nums, peak, n - 1, target);

        return first > second ? first : second;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 8, 12, 7, 5, 2, 1 };
        int target = 7;

        System.out.println(bitonicElement(nums, target));
    }
}