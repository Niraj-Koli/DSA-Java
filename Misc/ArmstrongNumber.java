import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    public static boolean isArmstrong(int n) {
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int rem = temp % 10;

            sum += (rem * rem * rem);

            temp /= 10;
        }

        if (n == sum) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Integer> armstrongRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = start; i <= end; i++) {
            int sum = 0;
            int temp = i;
            int order = (int) Math.floor(Math.log10(temp) + 1);

            while (temp > 0) {
                int digit = temp % 10;

                sum += Math.pow(digit, order);

                temp /= 10;
            }

            if (sum == i) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int alpha = 153;
        int beta = 1253;

        System.out.println(isArmstrong(alpha));
        System.out.println(isArmstrong(beta));

        int start = 100;
        int end = 10000;

        System.out.println(armstrongRange(start, end));
    }
}
