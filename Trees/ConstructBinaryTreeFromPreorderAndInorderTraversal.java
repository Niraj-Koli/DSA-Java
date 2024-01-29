/*
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 */

import java.util.HashMap;
import java.util.Map;

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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = constructTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);

        root.right = constructTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int m = preorder.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = constructTree(preorder, 0, m - 1, inorder, 0, n - 1, map);

        return root;
    }

    public static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode answer = buildTree(preorder, inorder);

        postorder(answer);
    }
}

// class Solution {
// private int i = 0;
// private int p = 0;

// public TreeNode buildTree(int[] preorder, int[] inorder) {
// return build(preorder, inorder, Integer.MIN_VALUE);
// }

// private TreeNode build(int[] preorder, int[] inorder, int stop) {
// if (p >= preorder.length) {
// return null;
// }
// if (inorder[i] == stop) {
// ++i;
// return null;
// }

// TreeNode node = new TreeNode(preorder[p++]);
// node.left = build(preorder, inorder, node.val);
// node.right = build(preorder, inorder, stop);
// return node;
// }
// }