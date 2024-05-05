// Time -> O(1) //
// Space -> O(1) //

class EvenOrOdd {
    private static String remainder(int n) {
        if (n % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    private static String or(int n) {
        if ((n | 1) > n) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    private static String and(int n) {
        if ((n & 1) == 1) {
            return "Odd";
        } else {
            return "Even";
        }
    }

    private static String xor(int n) {
        if ((n ^ 1) == n + 1) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    private static String lsb(int n) {
        if (Integer.toBinaryString(n).endsWith("0")) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args) {
        int number = 12;

        System.out.println(remainder(number));
        System.out.println(or(number));
        System.out.println(and(number));
        System.out.println(xor(number));
        System.out.println(lsb(number));
    }
}
