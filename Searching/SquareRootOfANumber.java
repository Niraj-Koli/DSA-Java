/*
 * You are given a positive integer ‘n’.
 * 
 * Your task is to find and return its square root. If ‘n’ is not a perfect
 * square, then return the floor value of sqrt(n).
 */

public class SquareRootOfANumber {

    // Time -> O(log(n))
    // Space -> O(1)

    private static long sqrtN(long n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + ((right - left) / 2);

            long value = mid * mid;

            if (value <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        long n = 7;

        System.out.println(sqrtN(n));
    }
}