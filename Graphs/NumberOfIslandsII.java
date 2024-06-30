/*
 * You are given a n,m which means the row and column of the 2D matrix and an
 * array of size k denoting the number of operations. Matrix elements is 0 if
 * there is water or 1 if there is land. Originally, the 2D matrix is all 0
 * which means there is no land in the matrix. The array has k operator(s) and
 * each operator has two integer A[i][0], A[i][1] means that you can change the
 * cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are
 * there in the matrix after each operation.You need to return an array of size
 * k.
 * Note : An island means group of 1s such that they share a common side.
 */

import java.util.ArrayList;

class NumberOfIslandsII {
    private static class DisjointSet {
        private ArrayList<Integer> parent = new ArrayList<Integer>();
        private ArrayList<Integer> size = new ArrayList<Integer>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        private int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return parent.get(node);
        }

        private void unionBySize(int u, int v) {
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

    // Time -> O((n * m) + k) //
    // Space -> O(n * m) //

    private static ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        int len = operators.length;

        DisjointSet dsu = new DisjointSet(n * m);

        boolean[][] vis = new boolean[n][m];

        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int islands = 0;

        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if (vis[row][col]) {
                res.add(islands);
                continue;
            }

            vis[row][col] = true;
            islands++;

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            for (int j = 0; j < 4; j++) {
                int nrow = row + dx[j];
                int ncol = col + dy[j];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && vis[nrow][ncol]) {
                    int nodeNo = row * m + col;
                    int neighborNo = nrow * m + ncol;

                    if (dsu.findUltimateParent(nodeNo) != dsu.findUltimateParent(neighborNo)) {
                        islands--;
                        dsu.unionBySize(nodeNo, neighborNo);
                    }
                }
            }
            res.add(islands);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        int[][] operators = {
                { 0, 0 }, { 0, 0 }, { 1, 1 }, { 1, 0 },
                { 0, 1 }, { 0, 3 }, { 1, 3 }, { 0, 4 },
                { 3, 2 }, { 2, 2 }, { 1, 2 }, { 0, 2 }
        };

        System.out.println(numOfIslands(n, m, operators));
    }
}