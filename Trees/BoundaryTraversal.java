/*
 * Write a program for the Anti-Clockwise Boundary traversal of a binary tree.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

public class BoundaryTraversal {
    public static boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode node = root.left;

        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public static void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode node = root.right;

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.offerLast(node.val);
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

    public static void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }

        if (root.left != null) {
            addLeaves(root.left, res);
        }

        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    public static List<Integer> printBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (!isLeaf(root)) {
            result.add(root.val);
        }

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
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

        List<Integer> answer = printBoundary(root);

        System.out.println(answer);
    }
}