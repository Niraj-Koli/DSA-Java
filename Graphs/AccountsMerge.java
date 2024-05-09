/*
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the
 * elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some common email to both accounts. Note that
 * even if two accounts have the same name, they may belong to different people
 * as people could have the same name. A person can have any number of accounts
 * initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class AccountsMerge {
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

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();

        DisjointSet dsu = new DisjointSet(n);

        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    dsu.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<ArrayList<String>> mergedMail = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<String>());
        }

        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = dsu.findUltimateParent(entry.getValue());

            mergedMail.get(node).add(mail);
        }

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).isEmpty()) {
                continue;
            }

            Collections.sort(mergedMail.get(i));

            ArrayList<String> temp = new ArrayList<String>();

            temp.add(accounts.get(i).get(0));

            for (String mail : mergedMail.get(i)) {
                temp.add(mail);
            }

            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> accounts = new ArrayList<ArrayList<String>>();

        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")));

        System.out.println(accountsMerge(accounts));
    }
}