/*
 * Given a BST, and a reference to a Node x in the BST. Find the Inorder
 * Predecessor of the given node in the BST.
 */

class InorderPredecessorInBST {
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

    private static TreeNode inorderPredecessor(TreeNode root, TreeNode x) {
        TreeNode predecessor = null;

        while (root != null) {
            if (x.data <= root.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode x = root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(inorderPredecessor(root, x).data);
    }
}
