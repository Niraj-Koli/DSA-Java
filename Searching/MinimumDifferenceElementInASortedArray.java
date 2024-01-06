/*
 * Given a sorted array, find the element in the array which has minimum
 * difference with the given number.
 */

public class MinimumDifferenceElementInASortedArray {
    public static int minimumDifferenceElement(int[] nums, int key) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == key) {
                return nums[middle];
            } else if (nums[middle] > key) {
                right = middle - 1;
            } else if (nums[middle] < key) {
                left = middle + 1;
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

        int answer = minimumDifferenceElement(nums, key);

        System.out.println(answer);
    }
}