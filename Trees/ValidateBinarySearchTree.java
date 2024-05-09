/*
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

class ValidateBinarySearchTree {
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

    private static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.data <= minVal || root.data >= maxVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);

    }

    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(isValidBST(root));
    }
}