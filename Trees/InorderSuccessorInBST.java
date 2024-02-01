/*
 * Given a BST, and a reference to a Node x in the BST. Find the Inorder
 * Successor of the given node in the BST.
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

public class InorderSuccessorInBST {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successor = null;

        while (root != null) {
            if (x.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode x = root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        TreeNode answer = inorderSuccessor(root, x);

        System.out.println(answer.val);
    }
}