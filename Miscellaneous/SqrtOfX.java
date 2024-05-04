/*
 * Given a non-negative integer n, return the square root of n rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * 
 * For example, do not use pow(n, 0.5) in c++ or n ** 0.5 in python.
 */

class SqrtOfX {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int mySqrt(int n) {
        if (n == 0) {
            return 0;
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid > n / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int n = 2147483647;

        System.out.println(mySqrt(n));
    }
}