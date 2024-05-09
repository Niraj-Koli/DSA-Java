class FactorialNumber {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int factorial(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(factorial(n));
    }
}