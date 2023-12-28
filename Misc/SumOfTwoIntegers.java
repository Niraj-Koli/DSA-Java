/*
 * Given two integers a and b, return the sum of the two integers without using
 * the operators + and -.
 */

public class SumOfTwoIntegers {
    public static int getSum(int x, int y) {
        while (y != 0) {
            int carry = x & y;

            x = x ^ y;

            y = carry << 1;
        }

        return x;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        int answer = getSum(a, b);

        System.out.println(answer);
    }
}

// public class Solution {
// public static int getSum(int x, int y) {
// return x + y;
// }
// }