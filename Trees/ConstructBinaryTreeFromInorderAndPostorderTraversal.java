/*
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 */

import java.util.HashMap;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    private static TreeNode constructTree(int[] inorder, int inStart,
            int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.data);

        int numsLeft = inRoot - inStart;

        root.left = constructTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);

        root.right = constructTree(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);

        return root;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = constructTree(inorder, 0, n - 1, postorder, 0, m - 1, map);

        return root;
    }

    private static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        preorder(buildTree(inorder, postorder));
    }
}