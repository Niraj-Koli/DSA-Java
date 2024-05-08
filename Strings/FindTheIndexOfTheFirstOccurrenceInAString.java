/*
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

class FindTheIndexOfTheFirstOccurrenceInAString {

    // Time -> O(n * m) //
    // Space -> O(1) //

    private static int strStr(String haystack, String needle) {
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(strStr(haystack, needle));
    }
}