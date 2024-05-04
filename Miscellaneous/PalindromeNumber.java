class PalindromeNumber {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int reverse(int number) {
        int res = 0;

        while (number > 0) {
            res = (res * 10) + number % 10;
            number = number / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        int number = 123464321;

        if (number == reverse(number)) {
            System.out.println("Palindrome Number");
        } else {
            System.out.println("Not A Palindrome Number");
        }
    }
}
