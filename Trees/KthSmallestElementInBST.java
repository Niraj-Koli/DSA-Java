/*
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
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

public class KthSmallestElementInBST {
    public static void traverse(TreeNode root, int k, int[] helper) {
        if (root == null) {
            return;
        }

        traverse(root.left, k, helper);

        helper[0]++;

        if (helper[0] == k) {
            helper[1] = root.val;
            return;
        }
        traverse(root.right, k, helper);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] helper = new int[2];

        traverse(root, k, helper);

        return helper[1];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        int answer = kthSmallest(root, k);

        System.out.println(answer);
    }
}

// public class Solution {
// public int kthSmallest(TreeNode root, int k) {
// if (root == null || k <= 0) {
// return -1;
// }

// int count = 0;
// TreeNode current = root;
// int result = -1;

// while (current != null) {
// if (current.left == null) {
// count++;
// if (count == k) {
// result = current.val;
// break;
// }
// current = current.right;
// } else {
// TreeNode predecessor = current.left;
// while (predecessor.right != null && predecessor.right != current) {
// predecessor = predecessor.right;
// }

// if (predecessor.right == null) {
// predecessor.right = current;
// current = current.left;
// } else {
// predecessor.right = null;
// count++;
// if (count == k) {
// result = current.val;
// break;
// }
// current = current.right;
// }
// }
// }
// System.gc();
// return result;
// }
// }