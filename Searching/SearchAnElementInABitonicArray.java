/*
 * Given a bitonic sequence of n distinct elements, and an integer x, the task
 * is to write a program to find given element x in the bitonic sequence in
 * O(log n) time.
 */

public class SearchAnElementInABitonicArray {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle > 0 && middle < n - 1) {
                if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                    return middle;
                } else if (nums[middle - 1] < nums[middle]) {
                    left = middle + 1;
                } else if (nums[middle - 1] > nums[middle]) {
                    right = middle - 1;
                }
            } else if (middle == 0) {
                if (nums[middle] > nums[middle + 1]) {
                    return middle;
                } else {
                    return middle + 1;
                }
            } else if (middle == n - 1) {
                if (nums[middle] > nums[middle - 2]) {
                    return middle;
                } else {
                    return middle - 1;
                }
            }
        }

        return -1;
    }

    public static int ascendingbinarySearch(int[] nums, int left, int right, int target) {
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

    public static int descendingbinarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                left = middle + 1;
            } else if (nums[middle] < target) {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static int bitonicElement(int[] nums, int target) {
        int n = nums.length;

        int peak = findPeakElement(nums);

        int first = ascendingbinarySearch(nums, 0, peak - 1, target);
        int second = descendingbinarySearch(nums, peak, n - 1, target);

        return first > second ? first : second;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 8, 12, 7, 5, 2, 1 };
        int target = 7;

        int answer = bitonicElement(nums, target);

        System.out.println(answer);
    }
}