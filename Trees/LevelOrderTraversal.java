/*
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 */

// Breadth First Search (BFS) : Level Order Traversal //

import java.util.ArrayDeque;
import java.util.ArrayList;

class LevelOrderTraversal {
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

    private static ArrayList<ArrayList<Integer>> levelOrderIterative(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> subList = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                subList.add(node.data);
            }
            res.add(subList);
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void levelOrderRecursive(TreeNode node, int level, ArrayList<ArrayList<Integer>> res) {
        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.data);

        levelOrderRecursive(node.left, level + 1, res);
        levelOrderRecursive(node.right, level + 1, res);
    }

    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        levelOrderRecursive(root, 0, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
        System.out.println(levelOrderIterative(root));
    }
}