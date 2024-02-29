/*
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 */

public class MajorityElement {

    // Time -> O(n)
    // Space -> O(1)

    private static int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println(majorityElement(nums));
    }
}