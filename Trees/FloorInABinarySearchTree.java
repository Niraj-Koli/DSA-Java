/*
 * You are given a BST(Binary Search Tree) with n number of nodes and value x.
 * your task is to find the greatest value node of the BST which is smaller than
 * or equal to x.
 * Note: when x is smaller than the smallest node of BST then returns -1.
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

public class FloorInABinarySearchTree {
    public static int findFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }

            if (key > root.val) {
                floor = root.val;
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

        int answer = findFloor(root, 9);

        System.out.println(answer);
    }
}