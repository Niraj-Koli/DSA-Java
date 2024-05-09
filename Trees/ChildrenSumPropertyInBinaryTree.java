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

class ChildrenSumPropertyInBinaryTree {
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
    // Space -> O(h) //

    private static void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child += root.left.data;
        }

        if (root.right != null) {
            child += root.right.data;
        }

        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            } else if (root.right != null) {
                root.right.data = root.data;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null) {
            total += root.left.data;
        }

        if (root.right != null) {
            total += root.right.data;
        }

        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }

    private static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
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