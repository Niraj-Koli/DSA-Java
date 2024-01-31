/*
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
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

public class DiameterOfBinaryTree {
    public static int heightOfTree(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightOfTree(node.left, diameter);
        int rightHeight = heightOfTree(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return (1 + (Math.max(leftHeight, rightHeight)));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];

        heightOfTree(root, diameter);

        return diameter[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int answer = diameterOfBinaryTree(root);

        System.out.println(answer);
    }
}

// class Solution {
// int result = 0;

// public int getHeight(TreeNode node) {
// if (node == null)
// return 0;
// int leftHeight = getHeight(node.left);
// int rightHeight = getHeight(node.right);
// result = Math.max(result, leftHeight + rightHeight);
// return 1 + Math.max(leftHeight, rightHeight);
// }

// public int diameterOfBinaryTree(TreeNode root) {
// if (root == null)
// return result;
// getHeight(root);
// return result;
// }
// }