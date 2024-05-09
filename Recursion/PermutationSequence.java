/*
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 */

import java.util.ArrayList;

class PermutationSequence {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static String getPermutation(int n, int k) {
        int fact = 1;

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }

        numbers.add(n);

        String res = "";

        k = k - 1;

        while (true) {
            res += numbers.get(k / fact);

            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;

        System.out.println(getPermutation(n, k));
    }
}