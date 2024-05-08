/*
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

class ValidPalindrome {

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean isPalindrome(String s) {
        String regex = "[^A-Za-z0-9]";

        String str = s.replaceAll(regex, "").toLowerCase();

        int n = str.length();

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }
}