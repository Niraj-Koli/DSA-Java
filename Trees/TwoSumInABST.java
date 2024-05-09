/*
 * Given the root of a binary search tree and an integer k, return true if there
 * exist two elements in the BST such that their sum is equal to k, or false
 * otherwise.
 */

import java.util.ArrayDeque;

class TwoSumInABST {
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

    private static class BSTIterator {
        private ArrayDeque<TreeNode> stack;
        private boolean reverse = true;

        // reverse = true -> before (Decreasing Order)
        // reverse = false -> next (Increasing Order)

        public BSTIterator(TreeNode root, boolean isReverse) {
            stack = new ArrayDeque<TreeNode>();
            reverse = isReverse;
            pushAll(root);
        }

        private int next() {
            TreeNode node = stack.pollLast();

            if (reverse == false) {
                pushAll(node.right);
            } else {
                pushAll(node.left);
            }
            return node.data;
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

    // Time -> O(n) //
    // Space -> O(h) //

    private static boolean findTarget(TreeNode root, int k) {
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

        System.out.println(findTarget(root, k));
    }
}