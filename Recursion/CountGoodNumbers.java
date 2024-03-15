/*
 * A digit string is good if the digits (0-indexed) at even indices are even and
 * the digits at odd indices are prime (2, 3, 5, or 7).
 * 
 * For example, "2582" is good because the digits (2 and 8) at even positions
 * are even and the digits (5 and 2) at odd positions are prime. However, "3245"
 * is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of length
 * n. Since the answer may be large, return it modulo 109 + 7.
 * 
 * A digit string is a string consisting of digits 0 through 9 that may contain
 * leading zeros.
 */

public class CountGoodNumbers {

    // Time -> O(log(n)) //
    // Space -> O(log(n)) //

    private static long powerMod(int a, long b, int mod) {
        if (b == 0) {
            return 1;
        }

        long x = powerMod(a, b / 2, mod) % mod;

        if (b % 2 == 0) {
            return ((x * x) % mod);
        } else {
            return ((((a * x) % mod) * x) % mod);
        }
    }

    private static int countGoodNumbers(long n) {
        int mod = 1000000007;

        return (int) ((powerMod(5, (n + 1) / 2, mod) * powerMod(4, n / 2, mod)) % mod);
    }

    public static void main(String[] args) {
        int n = 50;

        System.out.println(countGoodNumbers(n));
    }
}