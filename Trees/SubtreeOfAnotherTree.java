/*
 * Given the roots of two binary trees root and subRoot, return true if there is
 * a subtree of root with the same structure and node values of subRoot and
 * false otherwise.
 * 
 * A subtree of a binary tree tree is a tree that consists of a node in tree and
 * all of this node's descendants. The tree tree could also be considered as a
 * subtree of itself.
 */

public class SubtreeOfAnotherTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
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

        boolean ans = isSubtree(root, subRoot);

        System.out.println(ans);
    }
}

// class Solution {
// public boolean isSubtree(TreeNode root, TreeNode subRoot) {
// if(root == null && subRoot == null) return true;
// if(root == null || subRoot == null) return false;
// if(root.val == subRoot.val){
// if(isValid(root.left, subRoot.left) && isValid(root.right, subRoot.right))
// return true;

// }
// return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
// }
// public boolean isValid(TreeNode root, TreeNode subRoot) {
// if(root == null && subRoot == null) return true;
// if(root == null || subRoot == null) return false;

// if(root.val == subRoot.val){
// if(isSubtree(root.left, subRoot.left) && isSubtree(root.right,
// subRoot.right))
// return true;
// }
// return false;
// }
// }