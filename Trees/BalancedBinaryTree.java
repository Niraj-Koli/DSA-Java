/*
 * Given a binary tree, determine if it is
 * height-balanced
 * .
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

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    public static int dfsDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfsDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = dfsDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(rightDepth - leftDepth) > 1) {
            return -1;
        }

        return (1 + (Math.max(leftDepth, rightDepth)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean answer = isBalanced(root);

        System.out.println(answer);
    }
}

// class Solution {
// static boolean balance = true;

// public boolean isBalanced(TreeNode root) {
// balance = true;
// dfs(root);
// System.gc();
// return balance;
// }

// public int dfs(TreeNode curr) {
// if (curr == null || !balance) {
// return -1;
// }
// int left = dfs(curr.left) + 1;
// int right = dfs(curr.right) + 1;
// if (Math.abs(right - left) > 1) {
// balance = false;
// }
// return Math.max(left, right);
// }
// }