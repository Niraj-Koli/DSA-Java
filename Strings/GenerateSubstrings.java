import java.util.ArrayList;

class GenerateSubstrings {

    // Time -> O(n^3) //
    // Space -> O(1) //

    private static void subString(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j <= n; j++) {
                for (int k = i; k < i + j; k++) {
                    System.out.print(s.charAt(k));
                }
                System.out.println();
            }
        }
    }

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static ArrayList<String> generateSubstrings(String s) {
        int n = s.length();

        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                res.add(s.substring(i, j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "KaiZeR^";

        subString(s);

        System.out.println(generateSubstrings(s));
    }
}
