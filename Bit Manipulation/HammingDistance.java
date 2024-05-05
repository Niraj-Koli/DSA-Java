/*
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 */

// Time -> O(1) //
// Space -> O(1) //

class HammingDistance {
    private static int minBitFlips(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    private static int hammingDistance(int x, int y) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit1 = (x >> i) & 1;
            int bit2 = (y >> i) & 1;

            if (bit1 != bit2) {
                res++;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;

        System.out.println(minBitFlips(x, y));
        System.out.println(hammingDistance(x, y));
    }
}