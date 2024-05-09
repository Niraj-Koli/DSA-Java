/*
 * Given a binary tree. Find the size of its largest subtree that is a Binary
 * Search Tree.
 * Note: Here Size is equal to the number of nodes in the subtree.
 */

class LargestBSTInBinaryTree {
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
        private int maxSize;

        Node(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    // Time -> O(n) //
    // Space -> O(h) //

    private static Node maxSizeBSTHelper(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Node left = maxSizeBSTHelper(root.left);
        Node right = maxSizeBSTHelper(root.right);

        if (left.maxNode < root.data && root.data < right.minNode) {
            return new Node(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    private static int maxSizeBST(TreeNode root) {
        return maxSizeBSTHelper(root).maxSize;
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

        System.out.println(maxSizeBST(root));
    }
}