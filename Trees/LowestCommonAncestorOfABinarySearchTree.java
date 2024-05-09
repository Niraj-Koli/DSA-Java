/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */

class LowestCommonAncestorOfABinarySearchTree {
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
    // Space -> O(h) //

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    private static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode p = root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        TreeNode q = root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        preOrder(lowestCommonAncestor(root, p, q));
    }
}