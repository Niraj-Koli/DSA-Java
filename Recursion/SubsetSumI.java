/* Given a list arr of N integers, return sums of all subsets in it. */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SubsetSumI {
    public static void solve(ArrayList<Integer> arr, int n, int index, int sum, List<Integer> sumSubset) {
        if (index == n) {
            sumSubset.add(sum);
            return;
        }

        solve(arr, n, index + 1, sum + arr.get(index), sumSubset);

        solve(arr, n, index + 1, sum, sumSubset);
    }

    public static List<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        List<Integer> sumSubset = new ArrayList<Integer>();

        solve(arr, n, 0, 0, sumSubset);

        Collections.sort(sumSubset);

        return sumSubset;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 1 };

        ArrayList<Integer> arr = new ArrayList<>();

        for (int number : nums) {
            arr.add(number);
        }

        int n = 3;

        List<Integer> answer = subsetSums(arr, n);

        System.out.println(answer);
    }
}