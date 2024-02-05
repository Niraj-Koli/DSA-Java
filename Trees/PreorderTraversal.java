/*
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Preorder Traversal -> Root Left Right //

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

public class PreorderTraversal {
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        stack.offerLast(root);

        while (!stack.isEmpty()) {
            root = stack.pollLast();
            result.add(root.val);

            if (root.right != null) {
                stack.offerLast(root.right);
            }

            if (root.left != null) {
                stack.offerLast(root.left);
            }
        }

        return result;
    }

    public static void preorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderTraversalRecursive(root.left, res);
        preorderTraversalRecursive(root.right, res);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        preorderTraversalRecursive(root, result);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> answer = preorderTraversal(root);

        System.out.println(answer);
    }
}