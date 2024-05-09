/*
 * Given a BST and a number X, find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater
 * than X.
 * 
 * If Ceil could not be found, return -1.
 */

class CeilInABinarySearchTree {
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

    private static int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
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

        System.out.println(findCeil(root, 8));
    }
}