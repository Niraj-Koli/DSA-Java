import java.util.ArrayList;

public class ZAlgorithm {

    // Time -> O(n + m) //
    // Space -> O(n + m)) //

    private static int[] calculateZArray(String concat) {
        int n = concat.length();

        int[] zArray = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && concat.charAt(right - left) == concat.charAt(right)) {
                    right++;
                }
                zArray[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (zArray[k] < right - i + 1) {
                    zArray[i] = zArray[k];
                } else {
                    left = i;
                    while (right < n && concat.charAt(right - left) == concat.charAt(right)) {
                        right++;
                    }
                    zArray[i] = right - left;
                    right--;
                }
            }
        }
        
        return zArray;
    }

    private static ArrayList<Integer> zAlgorithm(String text, String pattern) {
        ArrayList<Integer> occurrences = new ArrayList<Integer>();

        String concat = pattern + "$" + text;

        int[] zArray = calculateZArray(concat);

        for (int i = 0; i < concat.length(); i++) {
            if (zArray[i] == pattern.length()) {
                occurrences.add(i - pattern.length() - 1);
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "ABABCDABCACDABABCABCAB";
        String pattern = "ABC";

        System.out.println(zAlgorithm(text, pattern));
    }
}
