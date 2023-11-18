public class LongestRepeatingSubsequence {
    public static String longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (t[i][j] == t[i - 1][j - 1] + 1) {
                result.append(x.charAt(i - 1));

                i--;
                j--;
            } else if (t[i][j] == t[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return result.reverse().toString();
    }

    public static String longestSubsequenceRepeated(String s) {
        return longestCommonSubsequence(s, s);
    }

    public static void main(String[] args) {
        String s = "axxzxy";

        String answer = longestSubsequenceRepeated(s);

        System.out.println(answer);
    }
}
