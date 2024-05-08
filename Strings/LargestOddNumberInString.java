/*
 * You are given a string num, representing a large integer. Return the
 * largest-valued odd integer (as a string) that is a non-empty substring of
 * num, or an empty string "" if no odd integer exists.
 * 
 * A substring is a contiguous sequence of characters within a string.
 */

class LargestOddNumberInString {

    // Time -> O(n) //
    // Space -> O(1) //

    private static String largestOddNumber(String num) {
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(num.charAt(i));

            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String num = "35427";

        System.out.println(largestOddNumber(num));
    }
}