/*
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a
 * queue to buy from you and order one at a time (in the order specified by
 * bills). Each customer will only buy one lemonade and pay with either a $5,
 * $10, or $20 bill. You must provide the correct change to each customer so
 * that the net transaction is that the customer pays $5.
 * 
 * Note that you do not have any change in hand at first.
 * 
 * Given an integer array bills where bills[i] is the bill the ith customer
 * pays, return true if you can provide every customer with the correct change,
 * or false otherwise.
 */

public class LemonadeChange {

    // Time -> O(n)
    // Space -> O(1)

    private static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else if (bill == 20 && ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 10, 10, 20 };

        System.out.println(lemonadeChange(bills));
    }
}