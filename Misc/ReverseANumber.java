public class ReverseANumber {

    // Time -> O(log10n) //
    // Space -> O(1) //

    public static int reverseModulo(int number) {
        int rev = 0;

        while (number > 0) {
            rev = (rev * 10) + number % 10;
            number = number / 10;
        }

        return rev;
    }

    // Time -> O(log n) //
    // Space -> O(n) //

    public static String reverseStringBuilder(int number) {
        String temp = "" + number;

        StringBuilder sb = new StringBuilder(temp);

        StringBuilder str = sb.reverse();

        return str.toString();
    }

    public static void main(String[] args) {
        int n = 47831;

        System.out.println(reverseModulo(n));
        System.out.println(reverseStringBuilder(n));
    }
}
