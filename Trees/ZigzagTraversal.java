/*
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class ZigzagTraversal {
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

    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        boolean leftToRight = true;

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

            if (!leftToRight) {
                Collections.reverse(subList);
            }

            leftToRight = !leftToRight;

            res.add(subList);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }
}