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

class NodeContainer {
    public int maxNode, minNode, maxSum;

    NodeContainer(int minNode, int maxNode, int maxSum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSum = maxSum;
    }
}

public class MaximumSumBSTInBinaryTree {
    public static int max = 0;

    public static NodeContainer maxSumBSTHelper(TreeNode root) {
        if (root == null) {
            return new NodeContainer(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeContainer left = maxSumBSTHelper(root.left);
        NodeContainer right = maxSumBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            max = Math.max(max, root.val + left.maxSum + right.maxSum);
            return new NodeContainer(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSum + right.maxSum + root.val);
        }

        return new NodeContainer(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum, right.maxSum));
    }

    public static int maxSumBST(TreeNode root) {
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

        int answer = maxSumBST(root);

        System.out.println(answer);
    }
}

// class Pair {
//     int max;
//     int min;
//     int sum;
//     int pos;

//     Pair(int a, int b, int c, int d) {
//         max = a;
//         min = b;
//         sum = c;
//         pos = d;
//     }
// }

// class Solution {
// Pair sum(TreeNode root, int[] ans) {
// if (root.left == null && root.right == null) {

// ans[0] = Math.max(ans[0], root.val);
// return new Pair(root.val, root.val, root.val, 0);
// }

// if (root.left != null && root.right != null) {
// Pair l = sum(root.left, ans);
// Pair r = sum(root.right, ans);
// if (l.pos == -1 || r.pos == -1) {
// return new Pair(0, 0, 0, -1);
// } else if (root.val > l.max && root.val < r.min) {
// ans[0] = Math.max(ans[0], l.sum + r.sum + root.val);
// return new Pair(Math.max(root.val, r.max), Math.min(root.val, l.min), l.sum +
// r.sum + root.val, 0);
// } else {
// return new Pair(0, 0, 0, -1);
// }
// } else if (root.left != null) {
// Pair l = sum(root.left, ans);
// if (l.pos == -1) {
// return new Pair(0, 0, 0, -1);
// } else if (root.val > l.max) {

// ans[0] = Math.max(ans[0], l.sum + root.val);
// return new Pair(Math.max(root.val, l.max), Math.min(root.val, l.min), l.sum +
// root.val, 0);
// } else {
// return new Pair(0, 0, 0, -1);
// }

// } else {
// Pair r = sum(root.right, ans);
// if (r.pos == -1) {
// return new Pair(0, 0, 0, -1);
// } else if (root.val < r.min) {

// ans[0] = Math.max(ans[0], r.sum + root.val);
// return new Pair(Math.max(root.val, r.max), Math.min(root.val, r.min), r.sum +
// root.val, 0);
// } else {
// return new Pair(0, 0, 0, -1);
// }

// }
// }

// public int maxSumBST(TreeNode root) {
// int[] ans = new int[1];
// sum(root, ans);
// return ans[0];
// }
// }