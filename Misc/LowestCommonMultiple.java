public class LowestCommonMultiple {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Time -> O(log(min(a, b))) //
    // Space -> O(log(min(a, b))) //

    public static int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 20;

        int answer = lcm(A, B);

        System.out.println(answer);
    }
}
