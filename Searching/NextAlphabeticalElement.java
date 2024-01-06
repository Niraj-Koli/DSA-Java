/*
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 */

public class NextAlphabeticalElement {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        int left = 0;
        int right = n - 1;

        char result = letters[0];

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (letters[middle] <= target) {
                left = middle + 1;
            } else if (letters[middle] > target) {
                result = letters[middle];

                right = middle - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'c';

        char answer = nextGreatestLetter(letters, target);

        System.out.println(answer);
    }
}

// class Solution {
// public static int find_ind(char[] letters, char target) {
// int low = 0, high = letters.length - 2;
// int mid;
// while (low <= high) {
// mid = low + (high - low) / 2;
// if (letters[mid] <= target && letters[mid + 1] > target)
// return mid;
// else if (letters[mid] <= target)
// low = mid + 1;
// else
// high = mid - 1;
// }
// return -1;
// }

// public char nextGreatestLetter(char[] letters, char target) {
// int ind = find_ind(letters, target);
// System.gc();
// return letters[ind + 1];
// }
// }