/*
 * Given a BST, and a reference to a Node x in the BST. Find the Inorder
 * Successor of the given node in the BST.
 */

class InorderSuccessorInBST {
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

    private static TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successor = null;

        while (root != null) {
            if (x.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode x = root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(inorderSuccessor(root, x).data);
    }
}