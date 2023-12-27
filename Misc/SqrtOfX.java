/*
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * 
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */

public class SqrtOfX {
    public static void main(String[] args) {
        int x = 2147483647;

        if (x == 0) {
            System.out.println(0);
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}

// class Solution {
// public int mySqrt(int x) {
// return (int) Math.sqrt(x);
// }
// }