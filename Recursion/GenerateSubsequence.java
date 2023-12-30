import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequence {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> list = new ArrayList<Integer>();

        generateSubsequence(nums, list, 0, result);

        return result;
    }

    public static void generateSubsequence(int[] nums, List<Integer> list, int index, List<List<Integer>> result) {
        int n = nums.length;
        
        if (index == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        generateSubsequence(nums, list, index + 1, result);

        list.remove(list.size() - 1);
        generateSubsequence(nums, list, index + 1, result);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2};

        List<List<Integer>> answer = subsets(nums);

        System.out.println(answer);
    }
}