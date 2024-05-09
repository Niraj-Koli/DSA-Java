/*
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */

class MaximumDepthOfBinaryTree {
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

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTree = maxDepth(root.left);
        int rightSubTree = maxDepth(root.right);

        return (1 + Math.max(leftSubTree, rightSubTree));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }
}