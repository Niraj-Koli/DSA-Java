/*
 * Given a binary tree, determine if it is
 * height-balanced
 * .
 */

class BalancedBinaryTree {
    static class TreeNode {
        public int data;
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

    private static int dfsDepth(TreeNode root) {
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

    private static boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
    }
}