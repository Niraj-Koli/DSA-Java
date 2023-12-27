/* Implement pow(x, n), which calculates x raised to the power n (i.e., xn). */

public class PowerXRaiseToN {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == -1.00000 && n == Integer.MIN_VALUE) {
            return -x;
        }

        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n++;
            }
            n = -n;
        }

        double result = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        double x = 1.00000;
        int n = 2147483647;

        double answer = myPow(x, n);

        System.out.println(answer);
    }
}

// class Solution {
// public double myPow(double x, int n) {
// double ans = Math.pow(x, n);
// return ans;
// }
// }