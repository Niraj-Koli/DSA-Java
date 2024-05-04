class GreatestCommonDivisor {

    // Time -> O(log(min(a, b))) //
    // Space -> O(log(min(a, b))) //

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int x = 30;
        int y = 20;

        System.out.println(gcd(x, y));
    }
}
