/* Given two binary strings a and b, return their sum as a binary string. */

public class AddBinary {
    public static String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        StringBuilder res = new StringBuilder();
        int carry = 0;

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
                i--;
            }

            if (j >= 0) {
                sum += Character.getNumericValue(b.charAt(j));
                j--;
            }

            res.insert(0, sum % 2);
            carry = sum / 2;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        String ans = addBinary(a, b);

        System.out.println(ans);
    }
}