/*
 * On a 2D plane, we place n stones at some integer coordinate points. Each
 * coordinate point may have at most one stone.
 * 
 * A stone can be removed if it shares either the same row or the same column as
 * another stone that has not been removed.
 * 
 * Given an array stones of length n where stones[i] = [xi, yi] represents the
 * location of the ith stone, return the largest possible number of stones that
 * can be removed.
 */

// Time -> O(N)
// Space -> (maxRow + maxCol)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
    private static class DisjointSet {
        ArrayList<Integer> parent = new ArrayList<Integer>();
        ArrayList<Integer> size = new ArrayList<Integer>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet dsu = new DisjointSet(maxRow + maxCol + 1);

        HashMap<Integer, Integer> stonesNodes = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            dsu.unionBySize(nodeRow, nodeCol);

            stonesNodes.put(nodeRow, 1);
            stonesNodes.put(nodeCol, 1);
        }

        int components = 0;

        for (Map.Entry<Integer, Integer> entry : stonesNodes.entrySet()) {
            if (dsu.findUltimateParent(entry.getKey()) == entry.getKey()) {
                components++;
            }
        }

        return n - components;
    }

    public static void main(String[] args) {
        int[][] stones = {
                { 0, 0 }, { 0, 1 }, { 1, 0 },
                { 1, 2 }, { 2, 1 }, { 2, 2 }
        };

        int ans = removeStones(stones);

        System.out.println(ans);
    }
}

// class Solution {
// public int numOfIslands = 0;

// public int removeStones(int[][] stones) {
// int[] parent = new int[20003];
// for (int[] stone : stones) {
// unionSets(stone[0] + 1, stone[1] + 10002, parent);
// }
// return stones.length - numOfIslands;
// }

// public void unionSets(int a, int b, int[] parent) {
// int parA = findParent(a, parent), parB = findParent(b, parent);
// if (parA != parB) {
// parent[parB] = parA;
// numOfIslands--;
// }
// return;
// }

// public int findParent(int node, int[] parent) {
// if (parent[node] == 0) {
// parent[node] = node;
// numOfIslands++;
// }
// if (parent[node] == node) {
// return node;
// }
// int par = findParent(parent[node], parent);
// parent[node] = par;
// return par;
// }
// }