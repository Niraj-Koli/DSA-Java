/*
 * You are given an integer ’n’.
 * 
 * Your task is to return a sorted array (in increasing order) containing all
 * the factorial numbers which are less than or equal to ‘n’.
 * 
 * The factorial number is a factorial of a positive integer, like 24 is a
 * factorial number, as it is a factorial of 4.
 */

import java.util.ArrayList;

class FactorialNumbersNotGreaterThanN {

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> res = new ArrayList<Long>();

        long fact = 1;
        int count = 1;

        while (fact <= n) {
            res.add(fact);
        
            count++;
            
            fact *= count;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 7;

        System.out.println(factorialNumbers(n));
    }
}