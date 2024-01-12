/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */

public class FactorialTrailingZeroes {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    public static int trailingZeroes(int n) {
        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 100;

        int answer = trailingZeroes(number);

        System.out.println(answer);
    }
}

