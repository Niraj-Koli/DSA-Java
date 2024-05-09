/*
 * You are given a BST(Binary Search Tree) with n number of nodes and value x.
 * your task is to find the greatest value node of the BST which is smaller than
 * or equal to x.
 * Note: when x is smaller than the smallest node of BST then returns -1.
 */

class FloorInABinarySearchTree {
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

    private static int findFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            if (key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);

        System.out.println(findFloor(root, 9));
    }
}