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

public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
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

        List<Integer> ans = findMinHeightTrees(n, edges);

        System.out.println(ans);
    }
}

// class Solution {
// public List<Integer> findMinHeightTrees(int n, int[][] edges) {
// if (n <= 2) {
// List<Integer> ans = new ArrayList<>();
// while (n > 0) {
// n--;
// ans.add(n);
// }
// return ans;
// }
// int[] neighbors = new int[n];
// int[] degree = new int[n];
// for (int[] edge : edges) {
// int start = edge[0];
// int end = edge[1];
// degree[start]++;
// degree[end]++;

// neighbors[start] ^= end;
// neighbors[end] ^= start;
// }
// LinkedList<Integer> leaves = new LinkedList();
// for (int i = 0; i < n; i++) {
// if (degree[i] == 1)
// leaves.offer(i);
// }
// while (n > 2) {
// int leavesSize = leaves.size();
// n -= leavesSize;
// while (leavesSize > 0) {
// leavesSize--;
// int leaf = leaves.poll();
// int neighbor = neighbors[leaf];

// this

// would

// neighbors[neighbor] ^= leaf;
// degree[neighbor]--;
// if (degree[neighbor] == 1)
// leaves.offer(neighbor);

// }

// }
// return leaves;

// }

// }