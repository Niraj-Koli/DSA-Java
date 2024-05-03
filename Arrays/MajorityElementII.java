/*
 * Given an integer array of size num, find all elements that appear more than ⌊
 * num/3 ⌋ times.
 */

import java.util.ArrayList;

class MajorityElementII {

    // Time -> O(2 * n) //
    // Space -> O(n) //

    private static ArrayList<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int element1 = 0;
        int element2 = 1;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            res.add(element1);
        }

        if (count2 > n / 3) {
            res.add(element2);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };

        System.out.println(majorityElement(nums));
    }
}