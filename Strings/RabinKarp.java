import java.util.ArrayList;

class RabinKarp {

    // Time -> O(n + m) //
    // Space -> O(max(n, m)) //

    private static ArrayList<Integer> rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int mod = (int) 1e9 + 9;
        int base = 31;

        long[] basePowers = new long[Math.max(n, m)];
        basePowers[0] = 1;

        for (int i = 1; i < basePowers.length; i++) {
            basePowers[i] = (basePowers[i - 1] * base) % mod;
        }

        long[] hashValues = new long[n + 1];
        for (int i = 0; i < n; i++) {
            hashValues[i + 1] = (hashValues[i] + (text.charAt(i) - 'a' + 1) * basePowers[i]) % mod;
        }

        long patternHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash + (pattern.charAt(i) - 'a' + 1) * basePowers[i]) % mod;
        }

        ArrayList<Integer> occurrences = new ArrayList<Integer>();

        for (int i = 0; i + m - 1 < n; i++) {
            long currentHash = (hashValues[i + m] + mod - hashValues[i]) % mod;

            if (currentHash == patternHash * basePowers[i] % mod) {
                occurrences.add(i);
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "ababcabcabc";
        String pattern = "abc";

        System.out.println(rabinKarp(text, pattern));
    }
}