/*
 * Given a sorted array, find the element in the array which has minimum
 * difference with the given number.
 */

class MinimumDifferenceElementInASortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int minimumDifferenceElement(int[] nums, int key) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == key) {
                return nums[mid];
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else if (nums[mid] < key) {
                left = mid + 1;
            }
        }

        int first = Math.abs(key - nums[left]);
        int second = Math.abs(key - nums[right]);

        if (first > second) {
            return nums[right];
        } else {
            return nums[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 8, 10, 15 };
        int key = 12;

        System.out.println(minimumDifferenceElement(nums, key));
    }
}