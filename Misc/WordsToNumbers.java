import java.util.ArrayList;

public class WordsToNumbers {
    public static String wordsToNumber(String s) {
        String s1 = s.replaceAll("one", "1");
        String s2 = s1.replaceAll("two", "2");
        String s3 = s2.replaceAll("three", "3");
        String s4 = s3.replaceAll("four", "4");
        String s5 = s4.replaceAll("five", "5");
        String s6 = s5.replaceAll("six", "6");
        String s7 = s6.replaceAll("seven", "7");
        String s8 = s7.replaceAll("eight", "8");
        String s9 = s8.replaceAll("nine", "9");
        String s0 = s9.replaceAll("zero", "0");

        String[] strArr = s0.split(" ");

        ArrayList<String> resultArr = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String currentElement = strArr[i];

            if (currentElement.equals("double")) {
                String nextElement = strArr[i + 1];

                resultArr.add(nextElement);
            } else if (currentElement.equals("triple")) {
                String nextElement = strArr[i + 1];

                resultArr.add(nextElement);
                resultArr.add(nextElement);
            } else {
                resultArr.add(currentElement);
            }
        }

        return String.join("", resultArr);

    }

    public static void main(String[] args) {
        String s = "seven three zero four one five nine five one zero";

        String answer = wordsToNumber(s);

        System.out.println(answer);
    }
}