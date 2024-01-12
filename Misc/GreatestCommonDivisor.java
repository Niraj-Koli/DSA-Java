public class GreatestCommonDivisor {

    // Time -> O(log(min(a, b))) //
    // Space -> O(log(min(a, b))) //

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 20;

        int answer = gcd(A, B);

        System.out.println(answer);
    }
}
