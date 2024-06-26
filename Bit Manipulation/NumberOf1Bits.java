/*
 * Write a function that takes the binary representation of an unsigned integer
 * and returns the number of '1' bits it has (also known as the Hamming weight).
 * 
 * Note:
 * 
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type. It should not
 * affect your implementation, as the integer's internal binary representation
 * is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3, the input represents the signed integer.
 * -3.
 */

// Time -> O(1) //
// Space -> O(1) //

class NumberOf1Bits {
    private static int rightAnd(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    private static int deleteLeastSignigicantBit(int n) {
        int count = 0;

        while (n != 0) {
            n = n & n - 1;
            count++;
        }

        return count;
    }

    private static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;

        System.out.println(rightAnd(n));
        System.out.println(deleteLeastSignigicantBit(n));
        System.out.println(hammingWeight(n));
    }
}