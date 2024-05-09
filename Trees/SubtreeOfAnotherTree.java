/*
 * Given the roots of two binary trees root and subRoot, return true if there is
 * a subtree of root with the same structure and node values of subRoot and
 * false otherwise.
 * 
 * A subtree of a binary tree tree is a tree that consists of a node in tree and
 * all of this node's descendants. The tree tree could also be considered as a
 * subtree of itself.
 */

class SubtreeOfAnotherTree {
    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // Time -> O(n) //
    // Space -> O(h) //

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }

        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));
    }
}