class ReverseANumber {

    // Time -> O(log10n) //
    // Space -> O(1) //

    private static int reverseModulo(int number) {
        int res = 0;

        while (number > 0) {
            res = (res * 10) + number % 10;
            number = number / 10;
        }

        return res;
    }

    // Time -> O(log n) //
    // Space -> O(n) //

    private static String reverseStringBuilder(int number) {
        StringBuilder str = new StringBuilder(Integer.toString(number));

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 47831;

        System.out.println(reverseModulo(n));
        System.out.println(reverseStringBuilder(n));
    }
}
