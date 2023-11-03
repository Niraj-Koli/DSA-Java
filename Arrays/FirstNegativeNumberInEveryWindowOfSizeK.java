/* Find the first negative number in every window of size k return 0 if not */

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInEveryWindowOfSizeK {
    public static List<Integer> firstNegative(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        ArrayList<Integer> support = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        while (j < len) {
            if (nums[j] < 0) {
                support.add(nums[j]);
            }

            if (j - i + 1 == k) {
                if (support.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(support.get(0));
                }

                support.remove(Integer.valueOf(nums[i]));
                i++;
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        List<Integer> answer = firstNegative(nums, k);

        System.out.println(answer);
    }
}
