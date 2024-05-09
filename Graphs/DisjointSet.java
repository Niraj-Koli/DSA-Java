
import java.util.ArrayList;

// Time -> O(4α) || O(n) || O(1) //

class DisjointSet {
    private ArrayList<Integer> rank = new ArrayList<Integer>();
    private ArrayList<Integer> parent = new ArrayList<Integer>();
    private ArrayList<Integer> size = new ArrayList<Integer>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
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

    public void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);

            int rankU = rank.get(ulp_u);

            rank.set(ulp_u, rankU + 1);
        }
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

    public static void main(String[] args) {
        DisjointSet dsu = new DisjointSet(7);

        dsu.unionBySize(1, 2);
        dsu.unionBySize(2, 3);
        dsu.unionBySize(4, 5);
        dsu.unionBySize(6, 7);
        dsu.unionBySize(5, 6);

        if (dsu.findUltimateParent(3) == dsu.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        dsu.unionBySize(3, 7);

        if (dsu.findUltimateParent(3) == dsu.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}