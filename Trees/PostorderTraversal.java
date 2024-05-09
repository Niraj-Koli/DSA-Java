/*
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Postorder Traversal -> Left Right Root //

import java.util.ArrayDeque;
import java.util.ArrayList;

class PostorderTraversal {
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

    private static ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.offerLast(root);
                root = root.left;
            } else {
                TreeNode node = stack.peekLast().right;

                if (node == null) {
                    node = stack.pollLast();
                    res.add(node.data);

                    while (!stack.isEmpty() && node == stack.peekLast().right) {
                        node = stack.pollLast();
                        res.add(node.data);
                    }
                } else {
                    root = node;
                }
            }
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void postorderTraversalRecursive(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        postorderTraversalRecursive(root.left, res);
        postorderTraversalRecursive(root.right, res);
        res.add(root.data);
    }

    private static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        postorderTraversalRecursive(root, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversalIterative(root));
    }
}