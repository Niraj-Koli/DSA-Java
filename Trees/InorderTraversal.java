/*
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Inorder Traversal -> Left Root Right //

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

public class InorderTraversal {
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.offerLast(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pollLast();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    public static void inorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left, res);
        res.add(root.val);
        inorderTraversalRecursive(root.right, res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        inorderTraversalRecursive(root, result);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> answer = inorderTraversal(root);

        System.out.println(answer);
    }
}