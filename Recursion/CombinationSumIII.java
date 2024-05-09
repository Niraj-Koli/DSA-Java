/*
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 */

import java.util.ArrayList;

class CombinationSumIII {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int k, int n, int start, int sum, ArrayList<Integer> combination,
            ArrayList<ArrayList<Integer>> res) {
        if (n == sum && k == combination.size()) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (combination.size() < k && !combination.contains(i)) {
                combination.add(i);
                solve(k, n, i + 1, sum + i, combination, res);
                combination.remove(combination.size() - 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        solve(k, n, 1, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        System.out.println(combinationSum3(k, n));
    }
}