/*
 * The children sum property is defined as, For every node of the tree, the
 * value of a node is equal to the sum of values of its children(left child and
 * right child).
 * 
 * Note:
 * 
 * The node values can be increased by 1 any number of times but decrement of
 * any node value is not allowed.
 * A value for a NULL node can be assumed as 0.
 * You are not allowed to change the structure of the given binary tree.
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

public class ChildrenSumPropertyInBinaryTree {
    public static void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child += root.left.val;
        }

        if (root.right != null) {
            child += root.right.val;
        }

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null) {
            total += root.left.val;
        }

        if (root.right != null) {
            total += root.right.val;
        }

        if (root.left != null || root.right != null) {
            root.val = total;
        }
    }

    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(35);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);

        changeTree(root);

        printPreOrder(root);
    }
}