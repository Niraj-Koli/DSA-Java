/*
 * Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 */

class CountCompleteTreeNodes {
    static class TreeNode {
        public int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int getHeightLeft(TreeNode root) {
        int height = 0;

        while (root.left != null) {
            height++;

            root = root.left;
        }

        return height;
    }

    // Time -> O(log(n)) //
    // Space -> O(1) //

    private static int getHeightRight(TreeNode root) {
        int height = 0;

        while (root.right != null) {
            height++;

            root = root.right;
        }

        return height;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightLeft(root);
        int rightHeight = getHeightRight(root);

        if (leftHeight == rightHeight) {
            return ((2 << leftHeight)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}