import java.util.ArrayList;

class CountOfSubsequencesWithSumEqualsToK {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static int subsequenceSum(int[] nums, int k, int index, ArrayList<Integer> subsequence, int sum) {
        if (sum > k) {
            return 0;
        }

        if (index == nums.length) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = subsequenceSum(nums, k, index + 1, subsequence, sum + nums[index]);

        int right = subsequenceSum(nums, k, index + 1, subsequence, sum);

        return left + right;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 2;

        System.out.println(subsequenceSum(nums, k, 0, new ArrayList<Integer>(), 0));
    }
}
