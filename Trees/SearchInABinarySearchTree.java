/*
 * You are given the root of a binary search tree (BST) and an integer data.
 * 
 * Find the node in the BST that the node's value equals data and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 */

class SearchInABinarySearchTree {
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

    // Time -> O(h) //
    // Space -> O(1) //

    private static TreeNode searchBST(TreeNode root, int data) {
        while (root != null && root.data != data) {
            root = data < root.data ? root.left : root.right;
        }

        return root;
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
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

        preOrder(searchBST(root, 2));
    }
}