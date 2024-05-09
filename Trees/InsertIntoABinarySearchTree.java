/*
 * You are given the root node of a binary search tree (BST) and a value to
 * insert into the tree. Return the root node of the BST after the insertion. It
 * is guaranteed that the new value does not exist in the original BST.
 * 
 * Notice that there may exist multiple valid ways for the insertion, as long as
 * the tree remains a BST after insertion. You can return any of them.
 */

class InsertIntoABinarySearchTree {
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

    // Time -> O(h) //
    // Space -> O(1) //

    private static TreeNode insertIntoBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        TreeNode node = root;

        while (true) {
            if (node.data <= data) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(data);
                    break;
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(data);
                    break;
                }
            }
        }

        return root;
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int data = 5;

        preOrder(insertIntoBST(root, data));
    }
}