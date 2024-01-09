/*
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 */

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int res = 0;

        for (int i = 31; i >= 0; i--) {
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

        int answer = hammingDistance(x, y);

        System.out.println(answer);
    }
}

// class Solution {
// public int hammingDistance(int x, int y) {
// int res = 0;
// int xor = x ^ y;
// while (xor != 0) {
// res += xor & 1;
// xor >>= 1;
// }
// return res;
// }
// }