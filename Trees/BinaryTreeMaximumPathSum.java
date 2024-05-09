/*
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them. A node can only appear in
 * the sequence at most once. Note that the path does not need to pass through
 * the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty
 * path.
 */

class BinaryTreeMaximumPathSum {
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

    private static int maximumPathSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, maximumPathSum(node.left, maxSum));
        int rightSum = Math.max(0, maximumPathSum(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.data);

        return (node.data + Math.max(leftSum, rightSum));
    }

    private static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];

        maxSum[0] = Integer.MIN_VALUE;

        maximumPathSum(root, maxSum);

        return maxSum[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}