import java.util.ArrayList;
import java.util.List;

public class GenerateSubstrings {
    public static void subString(String s) {
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

    public static List<String> generateSubstrings(String s) {
        int n = s.length();

        List<String> result = new ArrayList<String>();

        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                String substring = s.substring(start, end);
                result.add(substring);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "KaiZeR^";

        subString(s);

        List<String> answer = generateSubstrings(s);

        System.out.println(answer);
    }
}
