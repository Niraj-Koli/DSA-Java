/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */

class FactorialTrailingZeroes {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        return n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        int number = 100;

        System.out.println(trailingZeroes(number));
    }
}