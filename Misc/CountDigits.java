public class CountDigits {

    // Time -> O(log10(n)) //
    // Space -> O(1) //

    public static int iterative(long n) {
        int count = 0;

        while (n != 0) {
            n = n / 10;
            count++;
        }

        return count;
    }

    // Time -> O(log(n)) //
    // Space -> O(log(n)) //

    public static int recursive(long n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + recursive(n / 10);
    }

    // Time -> O(1) //
    // Space -> O(1) //

    public static int logarithm(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

    public static void main(String[] args) {
        long number = 345289467;

        System.out.println(iterative(number));
        System.out.println(recursive(number));
        System.out.println(logarithm(number));
    }
}
