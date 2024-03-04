public class ArithmeticOperations {

    // Time -> O(log(max(a,b)))
    // Space -> O(1)

    private static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    // Time -> O(log(max(a,b)))
    // Space -> O(1)

    private static int subtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    // Time -> O(log(b))
    // Space -> O(1)

    private static int multiply(int a, int b) {
        int res = 0;

        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>= 1;
        }

        return res;
    }

    // Time -> O(log(a))
    // Space -> O(1)

    private static int divide(int a, int b) {
        int quotient = 0;
        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

        a = Math.abs(a);
        b = Math.abs(b);

        while (a >= b) {
            int tempDivisor = b;
            int tempQuotient = 1;
            while ((tempDivisor << 1) <= a) {
                tempDivisor <<= 1;
                tempQuotient <<= 1;
            }
            a = subtract(a, tempDivisor);
            quotient = add(quotient, tempQuotient);
        }

        return sign * quotient;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 7;

        System.out.println(add(a, b));
        System.out.println(subtract(a, b));
        System.out.println(multiply(a, b));
        System.out.println(divide(a, b));
    }
}
