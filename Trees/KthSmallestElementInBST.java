/*
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 */

class KthSmallestElementInBST {
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

    private static void traverse(TreeNode root, int k, int[] helper) {
        if (root == null) {
            return;
        }

        traverse(root.left, k, helper);

        helper[0]++;

        if (helper[0] == k) {
            helper[1] = root.data;
            return;
        }
        traverse(root.right, k, helper);
    }

    private static int kthSmallest(TreeNode root, int k) {
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

        System.out.println(kthSmallest(root, k));
    }
}