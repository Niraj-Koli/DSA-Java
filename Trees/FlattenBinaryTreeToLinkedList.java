/*
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null.
 * The "linked list" should be in the same order as a pre-order traversal of the
 * binary tree.
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

public class FlattenBinaryTreeToLinkedList {
    public static TreeNode prevs = null;

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        dfs(root.left);

        root.right = prevs;
        root.left = null;
        prevs = root;
    }

    public static void bfs(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();

            if (node.right != null) {
                stack.offerLast(node.right);
            }

            if (node.left != null) {
                stack.offerLast(node.left);
            }

            if (!stack.isEmpty()) {
                node.right = stack.peekLast();
            }
            node.left = null;
        }
    }

    public static void morris(TreeNode root) {
        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                TreeNode prev = node.left;

                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        morris(root);

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}