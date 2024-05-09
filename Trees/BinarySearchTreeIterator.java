/*
 * Implement the BSTIterator class that represents an iterator over the in-order
 * traversal of a binary search tree (BST):
 * 
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should
 * be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the
 * pointer.
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 * 
 * You may assume that next() calls will always be valid. That is, there will be
 * at least a next number in the in-order traversal when next() is called.
 */

import java.util.ArrayDeque;

class BinarySearchTreeIterator {
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

    private ArrayDeque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        pushAll(root);
    }

    // Time -> O(1) //
    // Space -> O(1) //

    private boolean hasNext() {
        return !stack.isEmpty();
    }

    // Time -> O(1) //
    // Space -> O(1) //

    private int next() {
        TreeNode node = stack.pollLast();
        pushAll(node.right);

        return node.data;
    }

    // Time -> O(n) //
    // Space -> O(h) //

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.offer(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator(root);

        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }
}