/*
 * Using Morris Traversal, we can traverse the tree without using stack and
 * recursion. The idea of Morris Traversal is based on Threaded Binary Tree. In
 * this traversal, we first create links to Inorder successor and print the data
 * using these links, and finally revert the changes to restore original tree.
 */

import java.util.ArrayList;
import java.util.List;

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

public class MorrisTraversal {
    public static List<Integer> morrisPreOrder(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                preOrder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    preOrder.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preOrder;
    }

    public static List<Integer> morrisInOrder(TreeNode root) {
        List<Integer> inOrder = new ArrayList<Integer>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inOrder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inOrder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        List<Integer> preorder = morrisPreOrder(root);
        List<Integer> inorder = morrisInOrder(root);

        System.out.println("Morris Preorder Traversal: " + preorder);
        System.out.println("Morris Inorder Traversal: " + inorder);
    }
}