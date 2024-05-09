/*
 * You have been given an integer 'n'. Your task is to generate and return all
 * binary strings of length 'n' such that there are no consecutive 1's in the
 * string.
 * 
 * A binary string is that string which contains only ‘0’ and ‘1’.
 */

import java.util.ArrayList;
import java.util.Arrays;

class BinaryStringsWithNoConsecutive1s {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static void solve(int index, int n, char[] str, ArrayList<String> res) {
        if (index == n) {
            res.add(new String(str));
            return;
        }

        if (str[index - 1] == '1') {
            str[index] = '0';
            solve(index + 1, n, str, res);
        }

        if (str[index - 1] == '0') {
            str[index] = '0';
            solve(index + 1, n, str, res);
            str[index] = '1';
            solve(index + 1, n, str, res);
        }
    }

    private static ArrayList<String> generateString(int n) {
        ArrayList<String> res = new ArrayList<String>();

        if (n == 0) {
            return res;
        }
        char[] str = new char[n];

        str[0] = '0';
        solve(1, n, str, res);

        str[0] = '1';
        solve(1, n, str, res);

        Arrays.sort(str);

        return res;
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(generateString(n));
    }
}