class FactorialNumber {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(factorial(n));
    }
}