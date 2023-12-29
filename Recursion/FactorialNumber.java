public class FactorialNumber {
    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        int n = 10;

        int answer = factorial(n);

        System.out.println(answer);
    }
}