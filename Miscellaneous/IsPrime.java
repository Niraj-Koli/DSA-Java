class IsPrime {

    // Time -> O(sqrt(n)) //
    // Space -> O(1) //

    private static boolean isPrime(int n) {
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

    public static void main(String[] args) {
        int number = 13;

        System.out.println(isPrime(number));
    }
}
