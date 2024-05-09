/*
 * Given a sorted array arr[] of size N, some elements of array are moved to
 * either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or
 * arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * The task is to search for an element in this array.
 */

class SearchInAnNearlySortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int nearlySorted(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (mid - 1 >= left && nums[mid - 1] == target) {
                return mid - 1;
            } else if (mid + 1 <= right && nums[mid + 1] == target) {
                return mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 2;
            } else if (nums[mid] < target) {
                left = mid + 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 10, 30, 20, 40 };
        int target = 20;

        System.out.println(nearlySorted(nums, target));
    }
}