/*
 * The problem is to find the rightmost bit of a non-negative number 'N' that is
 * currently unset (i.e., has a value of 0) in its binary representation and set
 * it to 1.
 * 
 * Return the number after setting the rightmost unset bit of 'N'. If there are
 * no unset bits in N's binary representation, then the number should remain
 * unchanged.
 */

public class SetTheRightmostUnsetBit {

    // Time -> O(log(n))
    // Space -> O(1)

    private static int setBits(int n) {
        if (n == 0) {
            return 1;
        }

        int mask = 1;
        while ((n & mask) != 0) {
            mask <<= 1;
        }

        return n | mask;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(setBits(n));
    }
}