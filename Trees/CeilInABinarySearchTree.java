/*
 * Given a BST and a number X, find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater
 * than X.
 * 
 * If Ceil could not be found, return -1.
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

public class CeilInABinarySearchTree {
    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }

            if (key > root.val) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int answer = findCeil(root, 8);

        System.out.println(answer);
    }
}