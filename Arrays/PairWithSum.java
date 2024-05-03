/* Given a array of numbers, return the pair of numbers that add up to target */

import java.util.HashSet;

class PairWithSum {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean hasPairWithSum(int[] nums, int target) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(target - nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 4 };
        int target = 8;

        System.out.println(hasPairWithSum(nums, target));
    }

}