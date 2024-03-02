/*
 * You have been given an array ‘a’ of ‘n’ unique non-negative integers.
 * 
 * Find the second largest and second smallest element from the array.
 * 
 * Return the two elements (second largest and second smallest) as another array
 * of size 2.
 */

public class SecondLargestAndSmallestNumber {

    // Time -> O(n)
    // Space -> O(1)

    private static int[] getSecondOrderElements(int[] nums) {
        int n = nums.length;

        if (n == 0 || n == 1) {
            return new int[] { -1, -1 };
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            }

            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            }
        }

        return new int[] { secondLargest, secondSmallest };
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 3, 6, 7 };

        int[] ans = getSecondOrderElements(nums);

        System.out.println(ans[0] + " " + ans[1]);
    }
}