/*
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 */

import java.util.HashMap;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    private static TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.data);

        int numsLeft = inRoot - inStart;

        root.left = constructTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);

        root.right = constructTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int m = preorder.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = constructTree(preorder, 0, m - 1, inorder, 0, n - 1, map);

        return root;
    }

    private static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        postorder(buildTree(preorder, inorder));
    }
}