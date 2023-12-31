import java.util.ArrayList;
import java.util.List;

public class OneSubsequenceWithSumEqualsToK {
    public static boolean subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            if (sum == k) {
                System.out.println(subsequence);
                return true;
            } else {
                return false;
            }
        }

        subsequence.add(nums[index]);

        if (subsequenceSum(nums, k, index + 1, subsequence, sum + nums[index]) == true) {
            return true;
        }

        subsequence.remove(subsequence.size() - 1);

        if (subsequenceSum(nums, k, index + 1, subsequence, sum) == true) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 2;

        subsequenceSum(nums, k, 0, new ArrayList<Integer>(), 0);
    }
}
