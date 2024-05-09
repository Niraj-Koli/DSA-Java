import java.util.ArrayList;

class GenerateSubsequence {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void generateSubsequence(int[] nums, ArrayList<Integer> list, int index,
            ArrayList<ArrayList<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        list.add(nums[index]);
        generateSubsequence(nums, list, index + 1, res);

        list.remove(list.size() - 1);
        generateSubsequence(nums, list, index + 1, res);
    }

    private static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> list = new ArrayList<Integer>();

        generateSubsequence(nums, list, 0, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };

        System.out.println(subsets(nums));
    }
}