import java.util.ArrayList;

class AllSubsequenceWithSumEqualsToK {

    // Time -> O(2^n) //
    // Space -> O(2^n) //

    private static void subsequenceSum(int[] nums, int k, int index, ArrayList<Integer> subsequence, int sum,
            ArrayList<ArrayList<Integer>> res) {
        if (index == nums.length) {
            if (sum == k) {
                res.add(new ArrayList<Integer>(subsequence));
            }
            return;
        }

        subsequence.add(nums[index]);
        subsequenceSum(nums, k, index + 1, subsequence, sum + nums[index], res);

        subsequence.remove(subsequence.size() - 1);
        subsequenceSum(nums, k, index + 1, subsequence, sum, res);
    }

    private static ArrayList<ArrayList<Integer>> subsequenceSum(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        subsequenceSum(nums, k, 0, new ArrayList<Integer>(), 0, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3 };
        int k = 3;

        System.out.println(subsequenceSum(nums, k));
    }
}
