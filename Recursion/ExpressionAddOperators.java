/*
 * Given a string num that contains only digits and an integer target, return
 * all possibilities to insert the binary operators '+', '-', and/or '*' between
 * the digits of num so that the resultant expression evaluates to the target
 * value.
 * 
 * Note that operands in the returned expressions should not contain leading
 * zeros.
 */

import java.util.ArrayList;

class ExpressionAddOperators {

    // Time -> O(3^n) //
    // Space -> O(n) //

    private static void solve(String num, int target, ArrayList<String> res, String path, int pos, long eval,
            long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                res.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                solve(num, target, res, path + cur, i + 1, cur, cur);
            } else {
                solve(num, target, res, path + "+" + cur, i + 1, eval + cur, cur);

                solve(num, target, res, path + "-" + cur, i + 1, eval - cur, -cur);

                solve(num, target, res, path + "*" + cur, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    private static ArrayList<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<String>();

        if (num == null || num.length() == 0) {
            return res;
        }

        solve(num, target, res, "", 0, 0, 0);

        return res;
    }

    public static void main(String[] args) {
        String num = "232";
        int target = 8;

        System.out.println(addOperators(num, target));
    }
}