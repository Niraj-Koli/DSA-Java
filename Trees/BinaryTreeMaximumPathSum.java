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

public class BinaryTreeMaximumPathSum {
    public static int maximumPathSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, maximumPathSum(node.left, maxSum));
        int rightSum = Math.max(0, maximumPathSum(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);

        return (node.val + Math.max(leftSum, rightSum));
    }

    public static int maxPathSum(TreeNode root) {
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

        int answer = maxPathSum(root);

        System.out.println(answer);
    }
}

// class Solution {
// int answer = 0;

// public int maxPathSum(TreeNode root) {
// answer = root.val;
// helper(root);
// return answer;
// }

// public int helper(TreeNode root) {
// if (root == null) {
// return 0;
// }
// int left = Math.max(helper(root.left), 0);
// int right = Math.max(helper(root.right), 0);
// answer = Math.max(answer, left + right + root.val);
// return Math.max(left, right) + root.val;
// }
// }