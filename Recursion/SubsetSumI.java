/* Given a list arr of N integers, return sums of all subsets in it. */

import java.util.ArrayList;
import java.util.Collections;

class SubsetSumI {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int[] nums, int index, int sum, ArrayList<Integer> res) {
        if (index == nums.length) {
            res.add(sum);
            return;
        }

        solve(nums, index + 1, sum + nums[index], res);

        solve(nums, index + 1, sum, res);
    }

    private static ArrayList<Integer> subsetSums(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        solve(nums, 0, 0, res);

        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 7 };

        System.out.println(subsetSums(nums));
    }
}