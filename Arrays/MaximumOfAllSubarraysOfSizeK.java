/* Find maximum of each window and output it in a array */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumOfAllSubarraysOfSizeK {
    public static List<Integer> maxSubarrays(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        ArrayList<Integer> support = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();

        while (j < len) {
            int numAtJ = nums[j];

            support.add(numAtJ);

            if (support.size() == k) {
                int windowMax = Collections.max(support);

                answer.add(windowMax);

                support.remove(Integer.valueOf(nums[i]));

                i++;
            }
            j++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        List<Integer> result = maxSubarrays(nums, k);

        System.out.println(result);
    }
}
