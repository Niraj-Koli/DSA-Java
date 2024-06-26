/*
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * 
 * Each child i has a greed factor g[i], which is the minimum size of a cookie
 * that the child will be content with; and each cookie j has a size s[j]. If
 * s[j] >= g[i], we can assign the cookie j to the child i, and the child i will
 * be content. Your goal is to maximize the number of your content children and
 * output the maximum number.
 */

import java.util.Arrays;

class AssignCookies {

    // Time -> O((n * log n) + (m * log m) + (max(n, m))) //
    // Space -> O(1) //

    private static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        for (int i = 0, j = 0; i < n && j < m; j++) {
            if (g[i] <= s[j]) {
                res++;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] g = { 1, 2 };
        int[] s = { 1, 2, 3 };

        System.out.println(findContentChildren(g, s));
    }
}
