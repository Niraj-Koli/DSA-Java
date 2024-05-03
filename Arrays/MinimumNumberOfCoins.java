/*
 * Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100,
 * 500, 1000] valued coins and an amount 'N'.
 * 
 * Find the minimum coins needed to make the sum equal to 'N'. You have to
 * return the list containing the value of coins required in decreasing order.
 */

import java.util.ArrayList;

class MinimumNumberOfCoins {

    // Time -> O(n) //
    // Space -> O(1) //

    private static ArrayList<Integer> minCoins(int[] currency, int v) {
        int n = currency.length;

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (v >= currency[i]) {
                v -= currency[i];
                res.add(currency[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] currency = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int v = 49;

        System.out.println(minCoins(currency, v));
    }
}