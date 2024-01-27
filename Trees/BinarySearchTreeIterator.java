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

public class BinarySearchTreeIterator {
    private ArrayDeque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pollLast();
        pushAll(node.right);
        return node.val;
    }

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

        bSTIterator.next(); // return 3
        bSTIterator.next(); // return 7
        bSTIterator.hasNext(); // return True
        bSTIterator.next(); // return 9
        bSTIterator.hasNext(); // return True
        bSTIterator.next(); // return 15
        bSTIterator.hasNext(); // return True
        bSTIterator.next(); // return 20
        bSTIterator.hasNext(); // return False
    }
}

// class BSTIterator {
// PriorityQueue<Integer> heap;

// public BSTIterator(TreeNode root) {
// heap = new PriorityQueue<>();
// dfs(root);
// }

// private void dfs(TreeNode root) {
// if (root == null) {
// return;
// }
// dfs(root.left);
// heap.offer(root.val);
// dfs(root.right);
// }

// public int next() {
// int smallest = heap.poll();
// return smallest;
// }

// public boolean hasNext() {
// if (heap.size() > 0) {
// return true;
// }
// return false;
// }
// }
