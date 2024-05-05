class ModularExponentiation {

    // Time -> O(log y) //
    // Space -> O(1) //

    private static int power(int x, int y, int p) {
        int res = 1;

        x = x % p;

        if (x == 0) {
            return 0;
        }

        while (y > 0) {
            if ((y & 1) != 0) {
                res = (res * x) % p;
            }

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }

    public static void main(String[] args) {
        int x = 2312, y = 3434, p = 6789;

        System.out.println(power(x, y, p));
    }
}
