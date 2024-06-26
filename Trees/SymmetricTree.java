/*
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 */

class SymmetricTree {
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
    // Space -> O(n) //

    private static boolean isSymmetrical(TreeNode leftSubTree, TreeNode rightSubTree) {
        if (leftSubTree == null || rightSubTree == null) {
            return leftSubTree == rightSubTree;
        }

        if (leftSubTree.data != rightSubTree.data) {
            return false;
        }

        return isSymmetrical(leftSubTree.left, rightSubTree.right)
                && isSymmetrical(leftSubTree.right, rightSubTree.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetrical(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}