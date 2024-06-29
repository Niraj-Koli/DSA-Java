/*
 * Using Morris Traversal, we can traverse the tree without using stack and
 * recursion. The idea of Morris Traversal is based on Threaded Binary Tree. In
 * this traversal, we first create links to Inorder successor and print the data
 * using these links, and finally revert the changes to restore original tree.
 */

import java.util.ArrayList;

class MorrisTraversal {
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
    // Space -> O(1) //

    private static ArrayList<Integer> morrisPreOrder(TreeNode root) {
        ArrayList<Integer> preOrder = new ArrayList<Integer>();

        TreeNode node = root;

        while (node != null) {
            if (node.left == null) {
                preOrder.add(node.data);
                node = node.right;
            } else {
                TreeNode prev = node.left;

                while (prev.right != null && prev.right != node) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = node;
                    preOrder.add(node.data);
                    node = node.left;
                } else {
                    prev.right = null;
                    node = node.right;
                }
            }
        }

        return preOrder;
    }

    // Time -> O(n) //
    // Space -> O(1) //

    private static ArrayList<Integer> morrisInOrder(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<Integer>();

        TreeNode node = root;

        while (node != null) {
            if (node.left == null) {
                inOrder.add(node.data);
                node = node.right;
            } else {
                TreeNode prev = node.left;

                while (prev.right != null && prev.right != node) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    inOrder.add(node.data);
                    node = node.right;
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

        System.out.println("Morris Preorder Traversal: " + morrisPreOrder(root));
        System.out.println("Morris Inorder Traversal: " + morrisInOrder(root));
    }
}