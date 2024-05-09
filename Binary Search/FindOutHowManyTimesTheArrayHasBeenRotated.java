/*
 * Given an integer array arr of size N, sorted in ascending order (with
 * distinct values). Now the array is rotated between 1 to N times which is
 * unknown. Find how many times the array has been rotated.
 */

class FindOutHowManyTimesTheArrayHasBeenRotated {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int findKRotation(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };

        System.out.println(findKRotation(nums));
    }
}