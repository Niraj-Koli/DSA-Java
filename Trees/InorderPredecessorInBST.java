/*
 * Given a BST, and a reference to a Node x in the BST. Find the Inorder
 * Predecessor of the given node in the BST.
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

public class InorderPredecessorInBST {
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode x) {
        TreeNode predecessor = null;

        while (root != null) {
            if (x.val <= root.val) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode x = root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        TreeNode answer = inorderPredecessor(root, x);

        System.out.println(answer.val);
    }
}
