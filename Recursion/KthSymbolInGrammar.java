/*
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
 * Now in every subsequent row, we look at the previous row and replace each
 * occurrence of 0 with 01, and each occurrence of 1 with 10.
 * 
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row
 * is 0110.
 * Given two integer n and k, return the kth (1-indexed) symbol in the nth row
 * of a table of n rows.
 */

class KthSymbolInGrammar {

    // Time -> O(log(n)) //
    // Space -> O(log(n)) //

    private static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }

        int middle = (int) Math.pow(2, n - 1) / 2;

        if (k <= middle) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - middle);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 1;

        System.out.println(kthGrammar(n, k));
    }
}