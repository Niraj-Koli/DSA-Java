/*
 * Given an infinite sorted array consisting 0s and 1s. The problem is to find
 * the index of first ‘1’ in that array. As the array is infinite, therefore it
 * is guaranteed that number ‘1’ will be present in the array.
 */

class IndexOfFirst1InABinarySortedInfiniteArray {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int indexOfFirstOne(int[] nums) {
        int left = 0;
        int right = 1;

        int res = -1;

        while (nums[right] != 1) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == 1) {
                res = mid;

                right = mid - 1;
            } else if (nums[mid] == 0) {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1 };

        System.out.println(indexOfFirstOne(nums));
    }
}