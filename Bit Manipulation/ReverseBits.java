/* Reverse bits of a given 32 bits unsigned integer. */

class ReverseBits {

    // Time -> O(1) //
    // Space -> O(1) //

    private static int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 32; i++) {
            rev = (rev << 1) | (n & 1);
            n = n >> 1;
        }

        return rev;
    }

    public static void main(String[] args) {
        int n = 43261596;

        System.out.println("Original: " + Integer.toBinaryString(n));
        System.out.println("Original Decimal: " + n);

        int reversed = reverseBits(n);

        System.out.println("Reversed: " + Integer.toBinaryString(reversed));
        System.out.println("Reversed Decimal: " + reversed);
    }
}