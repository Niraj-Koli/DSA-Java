/*
 * Given an infinite sorted array consisting 0s and 1s. The problem is to find
 * the index of first ‘1’ in that array. As the array is infinite, therefore it
 * is guaranteed that number ‘1’ will be present in the array.
 */

public class IndexOfFirst1InABinarySortedInfiniteArray {
    public static int indexOfFirstOne(int[] nums) {
        int left = 0;
        int right = 1;

        int result = -1;

        while (nums[right] != 1) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == 1) {
                result = middle;

                right = middle - 1;
            } else if (nums[middle] == 0) {
                left = middle + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1 };

        int answer = indexOfFirstOne(nums);

        System.out.println(answer);
    }
}