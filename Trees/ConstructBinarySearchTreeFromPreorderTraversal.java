/*
 * Given an array of integers preorder, which represents the preorder traversal
 * of a BST (i.e., binary search tree), construct the tree and return its root.
 * 
 * It is guaranteed that there is always possible to find a binary search tree
 * with the given requirements for the given test cases.
 * 
 * A binary search tree is a binary tree where for every node, any descendant of
 * Node.left has a value strictly less than Node.val, and any descendant of
 * Node.right has a value strictly greater than Node.val.
 * 
 * A preorder traversal of a binary tree displays the value of the node first,
 * then traverses Node.left, then traverses Node.right.
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

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static TreeNode bst(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = bst(preorder, root.val, i);
        root.right = bst(preorder, bound, i);

        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };

        TreeNode answer = bstFromPreorder(preorder);

        inOrder(answer);
    }
}

// class Solution {
// public TreeNode bstFromPreorder(int[] preorder) {
// Stack<TreeNode> pending = new Stack<>();
// if (preorder.length == 0) {
// return null;
// }
// TreeNode root = new TreeNode(preorder[0]);
// pending.push(root);
// int i = 1;
// while (i < preorder.length) {
// TreeNode node = new TreeNode(preorder[i]);
// if (preorder[i] < pending.peek().val) {
// pending.peek().left = node;
// pending.push(node);
// } else {
// TreeNode parent = pending.pop();
// while (!pending.isEmpty() && pending.peek().val < preorder[i]) {
// parent = pending.pop();
// }
// parent.right = node;
// pending.push(node);
// }
// i++;
// }
// return root;

// }
// }