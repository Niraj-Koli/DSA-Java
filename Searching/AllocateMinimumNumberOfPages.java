/*
 * You have N books, each with A[i] number of pages. M students need to be
 * allocated contiguous books, with each student getting at least one book.
 * Out of all the permutations, the goal is to find the permutation where the
 * student with the most books allocated to him gets the minimum number of
 * pages, out of all possible permutations.
 * 
 * Note: Return -1 if a valid assignment is not possible, and allotment should
 * be in contiguous order.
 */

import java.util.Arrays;

public class AllocateMinimumNumberOfPages {
    public static boolean isValid(int[] nums, int n, int k, int maxPages) {
        int students = 1;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];

            if (sum > maxPages) {
                students++;
                sum = nums[i];
            }

            if (students > n) {
                return false;
            }
        }

        return true;
    }

    public static int[] findPages(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > left) {
                left = nums[i];
            }

            right += nums[i];
        }

        int sum = right;

        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (isValid(nums, n, k, middle)) {
                result = middle;

                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return (new int[] { result, sum - result });
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40 };
        int k = 2;

        int[] answer = findPages(nums, k);

        System.out.println(Arrays.toString(answer));
    }
}