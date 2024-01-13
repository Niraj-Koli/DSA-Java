import java.util.Arrays;

public class nthPrime {

    // Time -> O(n * sqrt(n)) //
    // Space -> O(1) //

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int nThPrime(int n) {
        int count = 0;
        int num = 2;

        while (count < n) {
            if (isPrime(num)) {
                count++;
            }

            if (count < n) {
                num++;
            }
        }

        return num;
    }

    // Time -> O(n * log(log(n))) //
    // Space -> O(n) //

    static int sieveOfEratosthenes(int n) {
        int limit = 1000000;

        boolean[] isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
