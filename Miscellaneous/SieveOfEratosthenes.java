import java.util.ArrayList;
import java.util.Arrays;

class SieveOfEratosthenes {

    // Time -> O(n * log(log(n))) //
    // Space -> O(n) //

    private static ArrayList<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int n = 50;

        System.out.println(sieveOfEratosthenes(n));
    }
}