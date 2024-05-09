/*
 * You are given the root of a binary search tree (BST), where the values of
 * exactly two nodes of the tree were swapped by mistake. Recover the tree
 * without changing its structure.
 */

class RecoverBinarySearchTree {
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

    private static TreeNode first;
    private static TreeNode prev;
    private static TreeNode middle;
    private static TreeNode last;

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null && (root.data < prev.data)) {
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

    // Time -> O(n) //
    // Space -> O(1) //

    private static void recoverTree(TreeNode root) {
        first = middle = last = null;

        prev = new TreeNode(Integer.MIN_VALUE);

        inOrder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
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