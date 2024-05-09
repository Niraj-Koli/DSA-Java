/*
 * Given a positive integer N, the task is to find all the N bit binary numbers
 * having more than or equal 1’s than 0’s for any prefix of the number.
 */

import java.util.ArrayList;

class PrintNBitBinaryNumbersHavingMore1sThan0s {

    // Time -> O(2^n) //
    // Space -> O(2^n) //

    private static ArrayList<String> res = new ArrayList<String>();

    private static void generatePrefixes(int ones, int zeros, int n, String output) {
        if (n == 0) {
            res.add(output);
            return;
        }

        generatePrefixes(ones + 1, zeros, n - 1, output + "1");

        if (ones > zeros) {
            generatePrefixes(ones, zeros + 1, n - 1, output + "0");
        }

        return;
    }

    private static ArrayList<String> NBitBinary(int n) {
        String output = "";

        int ones = 0;
        int zeros = 0;

        generatePrefixes(ones, zeros, n, output);

        return res;
    }

    public static void main(String[] args) {
        int n = 2;

        System.out.println(NBitBinary(n));
    }
}