/*
 * Given an array of integers preorder, which represents the preorder traversal
 * of a BST (i.e., binary search tree), construct the tree and return its root.
 * 
 * It is guaranteed that there is always possible to find a binary search tree
 * with the given requirements for the given test cases.
 * 
 * A binary search tree is a binary tree where for every node, any descendant of
 * Node.left has a value strictly less than Node.data, and any descendant of
 * Node.right has a value strictly greater than Node.data.
 * 
 * A preorder traversal of a binary tree displays the value of the node first,
 * then traverses Node.left, then traverses Node.right.
 */

class ConstructBinarySearchTreeFromPreorderTraversal {
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

    // Time -> O(n) //
    // Space -> O(h) //

    private static TreeNode bst(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = bst(preorder, root.data, i);
        root.right = bst(preorder, bound, i);

        return root;
    }

    private static TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    private static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };

        inOrder(bstFromPreorder(preorder));
    }
}