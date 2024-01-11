public class Factorial {

    // Time -> O(n) //
    // Space -> O(1) //

    public static int factorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 100;

        int answer = factorial(number);

        System.out.println(answer);
    }
}
