/*
 * A tree is an undirected graph in which any two vertices are connected by
 * exactly one path. In other words, any connected graph without simple cycles
 * is a tree.
 * 
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between
 * the two nodes ai and bi in the tree, you can choose any node of the tree as
 * the root. When you select a node x as the root, the result tree has height h.
 * Among all possible rooted trees, those with minimum height (i.e. min(h)) are
 * called minimum height trees (MHTs).
 * 
 * Return a list of all MHTs' root labels. You can return the answer in any
 * order.
 * 
 * The height of a rooted tree is the number of edges on the longest downward
 * path between the root and a leaf.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class MinimumHeightTrees {

    // Time -> O(V + E) //
    // Space -> O(V + E) //

    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        ArrayList<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            adj.get(vertex1).add(vertex2);
            adj.get(vertex2).add(vertex1);
        }

        ArrayList<Integer> leaves = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();

            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                { 3, 0 }, { 3, 1 }, { 3, 2 },
                { 3, 4 }, { 5, 4 }
        };

        System.out.println(findMinHeightTrees(n, edges));
    }
}