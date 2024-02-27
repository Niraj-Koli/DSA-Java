import java.util.ArrayList;

public class PrintAllDivisors {

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Integer> printDivisorsForce(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    // Time -> O(sqrt(n)) //
    // Space -> O(n) //

    private static ArrayList<Integer> printDivisorsQuotients(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }

            if (i != n / i) {
                divisors.add(n / i);
            }
        }

        return divisors;
    }

    public static void main(String[] args) {
        int n = 100;

        System.out.println(printDivisorsForce(n));
        System.out.println(printDivisorsQuotients(n));
    }
}
