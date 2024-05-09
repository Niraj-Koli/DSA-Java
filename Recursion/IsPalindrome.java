class IsPalindrome {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean isPalindrome(String s, int i) {
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

        System.out.println(isPalindrome(s, 0));
    }
}
