/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */

class LowestCommonAncestorOfABinaryTree {
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

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = root.left = new TreeNode(5);
        TreeNode q = root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(lowestCommonAncestor(root, p, q).data);
    }
}