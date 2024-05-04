class LowestCommonMultiple {

    // Time -> O(log(min(a, b))) //
    // Space -> O(log(min(a, b))) //

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Time -> O(log(min(a, b))) //
    // Space -> O(log(min(a, b))) //

    private static int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    public static void main(String[] args) {
        int x = 30;
        int y = 20;

        System.out.println(lcm(x, y));
    }
}
