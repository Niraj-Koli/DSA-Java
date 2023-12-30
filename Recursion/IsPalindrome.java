public class IsPalindrome {

    public static boolean isPalindrome(String s, int i) {
        int n = s.length();

        if (i >= n / 2) {
            return true;
        }

        if (s.charAt(i) != s.charAt(n - 1 - i)) {
            return false;
        }

        return isPalindrome(s, i + 1);
    }

    public static void main(String[] args) {
        String s = "radar";

        boolean answer = isPalindrome(s, 0);

        System.out.println(answer);
    }
}
