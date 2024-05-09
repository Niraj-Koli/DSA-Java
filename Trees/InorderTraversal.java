/*
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Inorder Traversal -> Left Root Right //

import java.util.ArrayDeque;
import java.util.ArrayList;

class InorderTraversal {
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
    // Space -> O(n) //

    private static ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.offer(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pollLast();
                res.add(node.data);
                node = node.right;
            }
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void inorderTraversalRecursive(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left, res);
        res.add(root.data);
        inorderTraversalRecursive(root.right, res);
    }

    private static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        inorderTraversalRecursive(root, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversalIterative(root));
    }
}