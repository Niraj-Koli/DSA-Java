/*
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

class CountingBits {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int brianKernighan(int num) {
        int count = 0;

        while (num > 0) {
            num &= (num - 1);
            count++;
        }

        return count;
    }

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int countSetBits(int num) {
        int count = 0;

        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }

        return count;
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(countSetBits(n));
        System.out.println(brianKernighan(n));

        int[] ans = countBits(n);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}