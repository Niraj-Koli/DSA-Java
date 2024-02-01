/*
 * Given a Binary Search Tree. Your task is to complete the function which will
 * return the Kth largest element without doing any modification in Binary
 * Search Tree.
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

public class KthLargestElementInBST {
    public static void traverse(TreeNode root, int k, int[] helper) {
        if (root == null) {
            return;
        }

        traverse(root.right, k, helper);

        helper[0]++;

        if (helper[0] == k) {
            helper[1] = root.val;
            return;
        }
        traverse(root.left, k, helper);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] helper = new int[2];

        traverse(root, k, helper);

        return helper[1];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        int answer = kthSmallest(root, k);

        System.out.println(answer);
    }
}