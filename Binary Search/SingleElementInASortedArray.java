/*
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 */

class SingleElementInASortedArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 7, 7, 10, 11, 11 };

        System.out.println(singleNonDuplicate(nums));
    }
}