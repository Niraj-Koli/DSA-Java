class Print1ToN {

    // Time -> O(n) //
    // Space -> O(n) //

    private static void oneToNUsingRecursion(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.print(i);

        oneToNUsingRecursion(i + 1, n);
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void nToOneUsingRecursion(int i) {
        if (i < 1) {
            return;
        }

        System.out.print(i);

        nToOneUsingRecursion(i - 1);
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void oneToNUsingBacktracking(int i) {
        if (i < 1) {
            return;
        }

        oneToNUsingBacktracking(i - 1);

        System.out.print(i);
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void nToOneUsingBacktracking(int i, int n) {
        if (i > n) {
            return;
        }

        nToOneUsingBacktracking(i + 1, n);

        System.out.print(i);
    }

    public static void main(String[] args) {
        int n = 3;

        oneToNUsingRecursion(1, n);
        System.out.println();

        nToOneUsingRecursion(n);
        System.out.println();

        oneToNUsingBacktracking(n);
        System.out.println();

        nToOneUsingBacktracking(1, n);
    }
}