/*
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree
 * which is also a Binary Search Tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

class MaximumSumBSTInBinaryTree {
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

    private static class Node {
        private int maxNode;
        private int minNode;
        private int maxSum;

        Node(int minNode, int maxNode, int maxSum) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSum = maxSum;
        }
    }

    private static int max = 0;

    private static Node maxSumBSTHelper(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Node left = maxSumBSTHelper(root.left);
        Node right = maxSumBSTHelper(root.right);

        if (left.maxNode < root.data && root.data < right.minNode) {
            max = Math.max(max, root.data + left.maxSum + right.maxSum);
            return new Node(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.maxSum + right.maxSum + root.data);
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum, right.maxSum));
    }

    private static int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);

        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(maxSumBST(root));
    }
}