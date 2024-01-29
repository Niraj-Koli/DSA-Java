/*
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
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

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode constructTree(int[] inorder, int inStart,
            int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = constructTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);

        root.right = constructTree(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = constructTree(inorder, 0, n - 1, postorder, 0, m - 1, map);

        return root;
    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        TreeNode answer = buildTree(inorder, postorder);

        preorder(answer);
    }
}

// class Solution {
// public int[] inorder;
// public int[] postorder;

// public TreeNode buildTree(int[] inorder, int[] postorder) {
// this.inorder = inorder;
// this.postorder = postorder;

// return buildTree(0, inorder.length - 1, 0, inorder.length - 1);
// }

// public TreeNode buildTree(int postStart, int postEnd, int inStart, int inEnd)
// {
// if (inStart > inEnd)
// return null;

// TreeNode output = new TreeNode(postorder[postEnd]);
// int length = 0;
// for (int i = inEnd; i >= inStart; i--) {
// if (inorder[i] == output.val) {
// length = inEnd - i;
// break;
// }
// }

// output.left = buildTree(postStart, postEnd - length - 1, inStart, inEnd -
// length - 1);
// output.right = buildTree(postEnd - length, postEnd - 1, inEnd - length + 1,
// inEnd);
// return output;
// }
// }