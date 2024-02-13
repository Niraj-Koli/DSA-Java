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
import java.util.List;

public class CombinationSumIII {
    public static void solve(int k, int n, List<List<Integer>> res, ArrayList<Integer> combination, int sum,
            int start) {
        if (n == sum && k == combination.size()) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (combination.size() < k && !combination.contains(i)) {
                combination.add(i);
                solve(k, n, res, combination, sum + i, i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        solve(k, n, res, new ArrayList<Integer>(), 0, 1);

        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        List<List<Integer>> ans = combinationSum3(k, n);

        System.out.println(ans);
    }
}

// class Solution {
// public List<List<Integer>> combinationSum3(int k, int n) {
// List<List<Integer>> ans = new ArrayList<>();
// dfs(k, n, 1, new ArrayList<>(), ans);
// return ans;
// }

// private void dfs(int k, int n, int s, List<Integer> path, List<List<Integer>>
// ans) {
// if (k == 0 && n == 0) {
// ans.add(new ArrayList<>(path));
// return;
// }
// if (k == 0 || n < 0)
// return;

// for (int i = s; i <= 9; ++i) {
// path.add(i);
// dfs(k - 1, n - i, i + 1, path, ans);
// path.remove(path.size() - 1);
// }
// }
// }