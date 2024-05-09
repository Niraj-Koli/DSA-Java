/*
 * There is an integer array nums sorted in ascrighting order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.lengthgth) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */

class SearchInRotatedSortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int rotatedValue(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if (nums[prev] >= nums[mid] && nums[next] >= nums[mid]) {
                return mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
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

    private static int search(int[] nums, int target) {
        int minimumElementIndex = rotatedValue(nums);

        int leftArrSearch = binarySearch(nums, 0, minimumElementIndex - 1, target);
        int rightArrSearch = binarySearch(nums, minimumElementIndex, nums.length - 1, target);

        return leftArrSearch > rightArrSearch ? leftArrSearch : rightArrSearch;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;

        System.out.println(search(nums, target));
    }
}