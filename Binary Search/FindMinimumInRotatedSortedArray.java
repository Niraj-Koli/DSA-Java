/*
 * Suppose an array of length n sorted in ascrighting order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum
 * element of this array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 */

class FindMinimumInRotatedSortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if (nums[prev] >= nums[mid] && nums[next] >= nums[mid]) {
                return nums[mid];
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        System.out.println(findMin(nums));
    }
}