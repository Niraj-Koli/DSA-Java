/*
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * 
 * You may return the answer in any order.
 */

import java.util.ArrayList;

class Combinations {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int n, int k, int index, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res) {
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

    private static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        solve(n, k, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        System.out.println(combine(n, k));
    }
}