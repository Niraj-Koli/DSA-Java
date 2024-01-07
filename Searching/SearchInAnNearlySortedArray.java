/*
 * Given a sorted array arr[] of size N, some elements of array are moved to
 * either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or
 * arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * The task is to search for an element in this array.
 */

public class SearchInAnNearlySortedArray {
    public static int nearlySorted(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (middle - 1 >= left && nums[middle - 1] == target) {
                return middle - 1;
            } else if (middle + 1 <= right && nums[middle + 1] == target) {
                return middle + 1;
            }

            if (nums[middle] > target) {
                right = middle - 2;
            } else if (nums[middle] < target) {
                left = middle + 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 10, 30, 20, 40 };
        int target = 20;

        int answer = nearlySorted(nums, target);

        System.out.println(answer);
    }
}