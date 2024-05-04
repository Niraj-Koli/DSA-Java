class Factorial {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int factorial(int n) {
        int res = 1;

        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public static void main(String[] args) {
        int number = 10;

        System.out.println(factorial(number));
    }
}
