class DigitExtraction {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    public static void main(String[] args) {
        int number = 1101027;

        while (number > 0) {
            int remainder = number % 10;

            System.out.print(remainder + " ");

            number = number / 10;
        }
    }
}