import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {

    // Time -> O(n * log(log(n))) //
    // Space -> O(n) //

    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> result = new ArrayList<Integer>();

        boolean prime[] = new boolean[n + 1];

        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 50;

        List<Integer> answer = sieveOfEratosthenes(n);

        System.out.println(answer);
    }
}