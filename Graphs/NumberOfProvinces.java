/*
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 */

// Time -> O(V + 2E)
// Space -> O(V)

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for (int vertex : adj.get(node)) {
            if (!vis[vertex]) {
                dfs(vertex, vis, adj);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[v];

        int provinces = 0;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                provinces++;
                dfs(i, vis, adj);
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 }
        };

        int ans = findCircleNum(isConnected);

        System.out.println(ans);
    }
}

// class Solution {
// public int findCircleNum(int[][] isConnected) {
// int n = isConnected.length;
// boolean[] visited = new boolean[n];
// int ans = 0;
// for (int i = 0; i < n; i++) {
// if (!visited[i]) {
// ans++;
// dfs(isConnected, i, visited);
// }
// }
// return ans;
// }

// private void dfs(int[][] isConnected, int index, boolean[] visited) {
// visited[index] = true;
// for (int j = 0; j < isConnected.length; j++) {
// if (!visited[j] && isConnected[index][j] == 1) {
// dfs(isConnected, j, visited);
// }
// }
// }
// }
