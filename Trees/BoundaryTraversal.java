/*
 * Write a program for the Anti-Clockwise Boundary traversal of a binary tree.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class BoundaryTraversal {
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

    private static boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode node = root.left;

        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.data);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode node = root.right;

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.offerLast(node.data);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pollLast());
        }
    }

    private static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null) {
            addLeaves(root.left, res);
        }

        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Integer> printBoundary(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (!isLeaf(root)) {
            res.add(root.data);
        }

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println(printBoundary(root));
    }
}