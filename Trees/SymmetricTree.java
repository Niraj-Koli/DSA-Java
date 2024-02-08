/*
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 */

public class SymmetricTree {
    public static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
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

        boolean answer = isSymmetric(root);

        System.out.println(answer);
    }
}