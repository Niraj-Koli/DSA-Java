/*
 * You are given the root of a binary search tree (BST) and an integer val.
 * 
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
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

public class SearchInABinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode answer = searchBST(root, 2);

        preOrder(answer);
    }
}

// class Solution {
// public TreeNode searchBST(TreeNode root, int val) {
// TreeNode node = root;
// return recursiveBST(node, val);
// }

// public TreeNode recursiveBST(TreeNode root, int val) {
// if (root.val == val) {
// return root;
// }
// if (root.left != null && root.val >= val) {
// return recursiveBST(root.left, val);
// } else if (root.right != null && root.val < val) {
// return recursiveBST(root.right, val);
// }
// return null;
// }
// }