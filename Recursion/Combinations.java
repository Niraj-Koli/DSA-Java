/*
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * 
 * You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void solve(int n, int k, int index, List<Integer> ds, List<List<Integer>> res) {
        if (ds.size() >= k) {
            res.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            ds.add(i);
            solve(n, k, i, ds, res);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        solve(n, k, 0, new ArrayList<>(), res);

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> ans = combine(n, k);

        System.out.println(ans);
    }
}

// class Solution {
// List<List<Integer>> result = new ArrayList<>();
// int n;
// int k;

// public List<List<Integer>> combine(int n, int k) {
// this.n = n;
// this.k = k;
// backtrack(1, new HashSet<>());

// return result;
// }

// private void backtrack(int current, Set<Integer> temp) {
// if (temp.size() == k) {
// result.add(new ArrayList<>(temp));
// return;
// }

// for (int i = current; i <= n; i++) {
// if (!temp.contains(i)) {
// temp.add(i);
// backtrack(i, temp);
// temp.remove(i);
// }
// }
// }
// }