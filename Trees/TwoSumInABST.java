/*
 * Given the root of a binary search tree and an integer k, return true if there
 * exist two elements in the BST such that their sum is equal to k, or false
 * otherwise.
 */

import java.util.ArrayDeque;

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

class BSTIterator {
    private ArrayDeque<TreeNode> stack;
    boolean reverse = true;

    // reverse = true -> before (Decreasing Order)
    // reverse = false -> next (Increasing Order)

    public BSTIterator(TreeNode root, boolean isReverse) {
        stack = new ArrayDeque<TreeNode>();
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pollLast();

        if (reverse == false) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.offer(node);

            if (reverse == false) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}

public class TwoSumInABST {
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = left.next();
            } else {
                j = right.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;

        boolean answer = findTarget(root, k);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean findTarget(TreeNode root, int k) {
// if (root.left == null && root.right == null)
// return false;
// return findTargetUtil(root, root, k);
// }

// public boolean findTargetUtil(TreeNode current, TreeNode root, int k) {
// if (current == null) {
// return false;
// }
// int remaining = k - current.val;
// if (isPresent(root, remaining, current)) {
// return true;
// }
// return findTargetUtil(current.left, root, k) || findTargetUtil(current.right,
// root, k);
// }

// public boolean isPresent(TreeNode root, int k, TreeNode current) {
// if (root == null) {
// return false;
// }
// if (root.val == k && current != root) {
// return true;
// }
// if (k < root.val) {
// return isPresent(root.left, k, current);
// }
// return isPresent(root.right, k, current);

// }
// }