/*
 * We are given a binary tree T and a node V. We need to print a path from the
 * root of the tree to the node.
 * 
 * Note:
 * 
 * No two nodes in the tree have the same data value.
 * It is assured that the node V is present and a path always exists.
 */

import java.util.ArrayList;

class PrintRootToNodePathInABinaryTree {
    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Time -> O(n) //
    // Space -> O(h) //

    private static boolean getPath(TreeNode root, int x, ArrayList<Integer> res) {
        if (root == null) {
            return false;
        }

        res.add(root.data);

        if (root.data == x) {
            return true;
        }

        if (getPath(root.left, x, res) || getPath(root.right, x, res)) {
            return true;
        }

        res.remove(res.size() - 1);

        return false;
    }

    private static ArrayList<Integer> pathFromRootToNode(TreeNode root, int node) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        getPath(root, node, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println(pathFromRootToNode(root, 7));
    }
}