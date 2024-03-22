import java.util.ArrayList;

public class KnuthMorrisPratt {

    // Time -> O(n + m) //
    // Space -> O(m)) //

    private static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();

        int[] lps = new int[m];

        for (int k = 0, i = 1; i < m; i++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = lps[k - 1];
            }

            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }

            lps[i] = k;
        }

        return lps;
    }

    private static ArrayList<Integer> kmpMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        ArrayList<Integer> occurrences = new ArrayList<Integer>();

        int[] lps = computePrefixFunction(pattern);

        for (int k = 0, i = 0; i < n; i++) {
            while (k > 0 && pattern.charAt(k) != text.charAt(i)) {
                k = lps[k - 1];
            }

            if (pattern.charAt(k) == text.charAt(i)) {
                k++;
            }

            if (k == m) {
                occurrences.add(i - m + 1);
                k = lps[k - 1];
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "AB";

        System.out.println(kmpMatch(text, pattern));
    }
}