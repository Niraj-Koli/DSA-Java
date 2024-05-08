/*
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 */

class CountNumberOfNiceSubarrays {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int atMostK(int[] nums, int k) {
        int n = nums.length;

        int res = 0;
        int odds = 0;

        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] % 2 != 0) {
                odds++;
            }

            while (odds > k) {
                if (nums[i] % 2 != 0) {
                    odds--;
                }
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
    }
}