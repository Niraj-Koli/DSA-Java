/*
 * Given an array of integers 'ARR’ of size ‘N’. Replace each element of this
 * array with its corresponding rank and return the array.
 * 
 * The rank of an element is an integer between 1 to ‘N’ inclusive that
 * represents how large the element is in comparison to other elements of the
 * array. The following rules can also define the rank of an element:
 * 
 * 1. It is an integer starting from 1.
 * 
 * 2. The larger the element, the larger the rank. If two elements are equal,
 * their rank must be the same.
 * 
 * 3. It should be as small as possible.
 */

import java.util.Arrays;
import java.util.HashMap;

class ReplaceEachElementOfArrayWithItsCorrespondingRank {

    // Time -> O((n * log(n)) * (2 * n)) //
    // Space -> O(n) //

    private static int[] replaceWithRank(int[] nums) {
        int n = nums.length;

        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sortedNums[i])) {
                map.put(sortedNums[i], rank++);
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 9, 6, 2 };

        int[] ans = replaceWithRank(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}