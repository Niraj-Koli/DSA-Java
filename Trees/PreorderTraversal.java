/*
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Preorder Traversal -> Root Left Right //

import java.util.ArrayDeque;
import java.util.ArrayList;

class PreorderTraversal {
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

    private static ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        stack.offer(root);

        while (!stack.isEmpty()) {
            root = stack.pollLast();
            res.add(root.data);

            if (root.right != null) {
                stack.offer(root.right);
            }

            if (root.left != null) {
                stack.offer(root.left);
            }
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void preorderTraversalRecursive(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.data);
        preorderTraversalRecursive(root.left, res);
        preorderTraversalRecursive(root.right, res);
    }

    private static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        preorderTraversalRecursive(root, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversalIterative(root));
    }
}