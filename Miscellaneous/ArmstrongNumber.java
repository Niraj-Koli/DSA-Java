import java.util.ArrayList;

class ArmstrongNumber {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int isArmstrong(int n) {
        int order = (int) Math.floor(Math.log10(n) + 1);

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, order);
            n /= 10;
        }

        return sum;
    }

    private static String printArmstrong(int number) {
        return (number == isArmstrong(number)) ? number + " is a Armstrong Number"
                : number + " is not a Armstrong Number";
    }

    // Time -> O((end - start + 1) * log(number)) //
    // Space -> O(end - start + 1) //

    private static ArrayList<Integer> armstrongRange(int start, int end) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = start; i <= end; i++) {
            int number = i;
            
            int sum = isArmstrong(number);

            if (sum == i) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int alpha = 153;
        int beta = 1253;
        int gamma = 9474;

        System.out.println(printArmstrong(alpha));
        System.out.println(printArmstrong(beta));
        System.out.println(printArmstrong(gamma));

        System.out.println();

        int start = 100;
        int end = 10000;

        System.out.println(armstrongRange(start, end));
    }
}
