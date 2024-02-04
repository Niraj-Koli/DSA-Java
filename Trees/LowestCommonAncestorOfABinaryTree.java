/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */

public class LowestCommonAncestorOfABinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = root.left = new TreeNode(5);
        TreeNode q = root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode answer = lowestCommonAncestor(root, p, q);

        System.out.println(answer.val);
    }
}

// class Solution {
// boolean contains(TreeNode root, TreeNode node) {
// if (root == null) {
// return false;
// }
// if (root == node)
// return true;
// return contains(root.left, node) || contains(root.right, node);

// }

// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
// if (p == root || q == root)
// return root;
// if (p == q)
// return p;
// boolean pInLeft = contains(root.left, p);
// boolean qInRight = contains(root.right, q);
// if (pInLeft && qInRight)
// return root;
// if (pInLeft && !qInRight)
// return lowestCommonAncestor(root.left, p, q);
// if (!pInLeft && qInRight)
// return lowestCommonAncestor(root.right, p, q);
// return root;
// }
// }