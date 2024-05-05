// Time -> O(1) //
// Space -> O(1) //

class XORFromRanges {
    private static int xorOfn(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }

    private static int findXOR(int l, int r) {
        int xorR = xorOfn(r);
        int xorLMinus1 = xorOfn(l - 1);

        return xorR ^ xorLMinus1;
    }

    public static void main(String[] args) {
        int n = 14;

        System.out.println(xorOfn(n));

        int l = 3;
        int r = 9;

        System.out.println(findXOR(l, r));
    }
}
