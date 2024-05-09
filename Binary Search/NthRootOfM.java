/*
 * You are given two positive integers 'n' and 'm'. You have to return the 'nth'
 * root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.
 */

class NthRootOfM {

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int func(int mid, int n, int m) {
        long res = 1;

        for (int i = 1; i <= n; i++) {
            res = res * mid;

            if (res > m) {
                return 2;
            }
        }

        if (res == m) {
            return 1;
        }

        return 0;
    }

    private static int nthRoot(int n, int m) {
        int left = 1;
        int right = m;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int value = func(mid, n, m);

            if (value == 1) {
                return mid;
            } else if (value == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;

        System.out.println(nthRoot(n, m));
    }
}