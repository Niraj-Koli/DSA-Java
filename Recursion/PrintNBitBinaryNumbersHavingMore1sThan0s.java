/*
 * Given a positive integer N, the task is to find all the N bit binary numbers
 * having more than or equal 1’s than 0’s for any prefix of the number.
 */

import java.util.ArrayList;
import java.util.List;

public class PrintNBitBinaryNumbersHavingMore1sThan0s {
    public static List<String> result = new ArrayList<String>();

    public static void generatePrefixes(int ones, int zeros, int n, String output) {
        if (n == 0) {
            result.add(output);
            return;
        }

        generatePrefixes(ones + 1, zeros, n - 1, output + "1");

        if (ones > zeros) {
            generatePrefixes(ones, zeros + 1, n - 1, output + "0");
        }

        return;
    }

    public static List<String> NBitBinary(int n) {
        String output = "";

        int ones = 0;
        int zeros = 0;

        generatePrefixes(ones, zeros, n, output);

        return result;
    }

    public static void main(String[] args) {
        int n = 2;

        List<String> answer = NBitBinary(n);

        System.out.println(answer);
    }
}