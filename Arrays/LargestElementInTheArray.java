/*
 * Given an array ‘arr’ of size ‘n’ find the largest element in the array.
 */

public class LargestElementInTheArray {

    // Time -> O(n)
    // Space -> O(1)

    private static int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 8, 6, 7, 6 };

        System.out.println(largestElement(nums));
    }
}