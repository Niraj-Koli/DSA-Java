/*
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 */

class IsomorphicStrings {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean isIsomorphic(String s, String t) {
        int n = s.length();

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < n; i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if (map1[chs] != map2[cht]) {
                return false;
            }

            map1[chs] = i + 1;
            map2[cht] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }
}