/*
 * Given a Binary Tree, return Left view of it. Left view of a Binary Tree is
 * set of nodes visible when tree is visited from Left side. The task is to
 * complete the function leftView(), which accepts root of the tree as argument.
 * 
 * Left view of following tree is 1 2 4 8.
 * 
 * 1
 * / \
 * 2 3
 * / \ / \
 * 4 5 6 7
 * \
 * 8
 */

import java.util.ArrayList;

class LeftViewOfBinaryTree {
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

    private static void leftView(TreeNode root, int level, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }

        leftView(root.left, level + 1, res);
        leftView(root.right, level + 1, res);
    }

    private static ArrayList<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        leftView(root, 0, res);

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

        System.out.println(leftSideView(root));
    }
}