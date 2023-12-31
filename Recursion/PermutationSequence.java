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
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int fact = 1;

        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }

        numbers.add(n);

        String result = "";

        k = k - 1;

        while (true) {
            result += numbers.get(k / fact);

            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;

        String answer = getPermutation(n, k);

        System.out.println(answer);
    }
}

// class Solution {
// public String getPermutation(int n, int k) {

// if (k <= 0) {
// return "";
// }
// int[] count = new int[] { 0 };
// String[] result = new String[] { "" };
// StringBuilder sb = new StringBuilder();
// boolean[] visited = new boolean[n + 1]; // check the number has been used or
// not
// findKthPermutation(n, k, count, result, sb, visited, 0);
// return result[0];
// }

// private void findKthPermutation(int n, int k, int[] count, String[] result,
// StringBuilder sb, boolean[] visited,
// int index) {
// if (index == n) {
// count[0]++;
// if (count[0] == k) {
// result[0] = sb.toString();
// }
// return;
// }
// for (int i = 1; i <= n; i++) {
// if (!visited[i]) {
// visited[i] = true;
// sb.append(i);
// findKthPermutation(n, k, count, result, sb, visited, index + 1);
// visited[i] = false;
// sb.deleteCharAt(sb.length() - 1);
// }
// }
// }
// }