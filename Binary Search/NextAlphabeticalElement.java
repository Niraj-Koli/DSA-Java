/*
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 */

class NextAlphabeticalElement {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        int left = 0;
        int right = n - 1;

        char res = letters[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                res = letters[mid];

                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'c';

        System.out.println(nextGreatestLetter(letters, target));
    }
}