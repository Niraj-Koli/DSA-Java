class SwapTwoIntegers {

    // Time -> O(1) //
    // Space -> O(1) //
    public static void main(String[] args) {
        int x = 6;
        int y = 5;

        System.out.println(x + " " + y);

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(x + " " + y);
    }
}
