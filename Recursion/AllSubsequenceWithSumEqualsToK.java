import java.util.ArrayList;
import java.util.List;

public class AllSubsequenceWithSumEqualsToK {
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    private static void subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            if (sum == k) {
                System.out.println(subsequence);
            }
            return;
        }

        subsequence.add(nums[index]);
        subsequenceSum(nums, k, index + 1, subsequence, sum + nums[index]);

        subsequence.remove(subsequence.size() - 1);
        subsequenceSum(nums, k, index + 1, subsequence, sum);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 2;

        subsequenceSum(nums, k);
    }
}
