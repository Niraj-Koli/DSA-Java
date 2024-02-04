/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LowestCommonAncestorOfABinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode p = root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        TreeNode q = root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode answer = lowestCommonAncestor(root, p, q);

        preOrder(answer);
    }
}

// class Solution {
// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
// if (root == null || root == p || root == q) {
// return root;
// }
// TreeNode left_anc = lowestCommonAncestor(root.left, p, q);
// TreeNode right_anc = lowestCommonAncestor(root.right, p, q);
// if (left_anc != null && right_anc != null) {
// return root;
// }
// if (left_anc != null) {
// return left_anc;
// }
// if (right_anc != null) {
// return right_anc;
// }
// return null;
// }
// }