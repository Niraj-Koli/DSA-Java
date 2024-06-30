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

class NumberOfProvinces {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static void dfs(int v, int node, boolean[] vis, int[][] isConnected) {
        vis[node] = true;

        for (int neighbor = 0; neighbor < v; neighbor++) {
            if (!vis[neighbor] && isConnected[node][neighbor] == 1) {
                dfs(v, neighbor, vis, isConnected);
            }
        }
    }

    private static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        boolean[] vis = new boolean[v];

        int provinces = 0;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(v, i, vis, isConnected);
                provinces++;
            }
        }

        return provinces;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 }
        };

        System.out.println(findCircleNum(isConnected));
    }
}
