public class Print1ToN {
    public static void oneToNUsingRecursion(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i);

        oneToNUsingRecursion(i + 1, n);
    }

    public static void nToOneUsingRecursion(int i) {
        if (i < 1) {
            return;
        }

        System.out.println(i);

        nToOneUsingRecursion(i - 1);
    }

    public static void oneToNUsingBacktracking(int i) {
        if (i < 1) {
            return;
        }

        oneToNUsingBacktracking(i - 1);

        System.out.println(i);
    }

    public static void nToOneUsingBacktracking(int i, int n) {
        if (i > n) {
            return;
        }

        nToOneUsingBacktracking(i + 1, n);

        System.out.println(i);
    }

    public static void main(String[] args) {
        int n = 3;

        oneToNUsingRecursion(1, n);
        nToOneUsingRecursion(n);
        oneToNUsingBacktracking(n);
        nToOneUsingBacktracking(1, n);
    }
}