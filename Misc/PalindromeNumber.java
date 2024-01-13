public class PalindromeNumber {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    public static boolean isPalindrome(int n) {
        int rev = 0;
        int num = n;

        while (num > 0) {
            rev = (rev * 10) + num % 10;
            num = num / 10;
        }

        if (n == rev) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int number = 123464321;

        System.out.println(isPalindrome(number));
    }
}
