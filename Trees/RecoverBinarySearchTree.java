/*
 * You are given the root of a binary search tree (BST), where the values of
 * exactly two nodes of the tree were swapped by mistake. Recover the tree
 * without changing its structure.
 */

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

public class RecoverBinarySearchTree {
    public static TreeNode first;
    public static TreeNode prev;
    public static TreeNode middle;
    public static TreeNode last;

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null && (root.val < prev.val)) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inOrder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        first = middle = last = null;

        prev = new TreeNode(Integer.MIN_VALUE);

        inOrder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        printInOrder(root);

        System.out.println();

        recoverTree(root);

        printInOrder(root);
    }
}

// class Solution {
// TreeNode first;
// TreeNode second;
// TreeNode pre = new TreeNode(Integer.MIN_VALUE);

// public void recoverTree(TreeNode root) {
// inorder(root);

// int num = first.val;
// first.val = second.val;
// second.val = num;
// }

// public void inorder(TreeNode root) {
// if (root == null)
// return;
// inorder(root.left);
// if (first == null && root.val < pre.val)
// first = pre;
// if (first != null && root.val < pre.val)
// second = root;
// pre = root;
// inorder(root.right);
// }
// }