/*
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom
 */

import java.util.ArrayList;

class RightViewOfBinaryTree {
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

    private static void rightView(TreeNode root, int level, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }

        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);
    }

    private static ArrayList<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        rightView(root, 0, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(rightSideView(root));
    }
}
