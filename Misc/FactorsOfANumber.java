import java.util.ArrayList;
import java.util.List;

public class FactorsOfANumber {

    // Time -> O(sqrt(n)) //
    // Space -> O(sqrt(n)) //

    public static List<Integer> printDivisorts(int n) {
        List<Integer> result = new ArrayList<Integer>();

        ArrayList<Integer> helper = new ArrayList<Integer>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    result.add(i);
                } else {
                    result.add(i);
                    helper.add(n / i);
                }
            }
        }

        for (int i = helper.size() - 1; i >= 0; i--) {
            result.add(helper.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 100;

        List<Integer> answer = printDivisorts(number);

        System.out.println(answer);
    }
}
