/*
 * Given a sorted dictionary of an alien language having N words and k starting
 * alphabets of standard dictionary. Find the order of characters in the alien
 * language.
 * Note: Many orders may be possible for a particular test case, thus you may
 * return any valid order and output will be 1 if the order of string returned
 * by the function is correct else 0 denoting incorrect string returned.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class AlienDictionary {

    // Time -> O(n + k) //
    // Space -> O(n + k) //

    private static ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            int node = queue.poll();

            res.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }

    private static String findOrder(String[] dict, int k) {
        int n = dict.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        ArrayList<Integer> topo = topoSort(k, adj);

        StringBuilder order = new StringBuilder();

        for (int letter : topo) {
            order.append((char) (letter + 'a'));
        }

        return order.toString();
    }

    public static void main(String[] args) {
        String[] dict = { "baa", "abcd", "abac", "cab", "cad" };
        int k = 4;

        System.out.println(findOrder(dict, k));
    }
}