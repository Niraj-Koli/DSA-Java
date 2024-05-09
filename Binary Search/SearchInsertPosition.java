/*
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */

class SearchInsertPosition {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = n;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                res = mid;

                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }
}