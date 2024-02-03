/*
 * Given a binary tree. Find the size of its largest subtree that is a Binary
 * Search Tree.
 * Note: Here Size is equal to the number of nodes in the subtree.
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

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

public class LargestBSTInBinaryTree {
    public static NodeValue maxSizeBSTHelper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = maxSizeBSTHelper(root.left);
        NodeValue right = maxSizeBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static int maxSizeBST(TreeNode root) {
        return maxSizeBSTHelper(root).maxSize;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        int answer = maxSizeBST(root);

        System.out.println(answer);
    }
}