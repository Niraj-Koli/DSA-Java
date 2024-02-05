/*
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 */

// Depth First Search (DFS) : Postorder Traversal -> Left Right Root //

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

public class PostorderTraversal {
    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.offerLast(root);
                root = root.left;
            } else {
                TreeNode node = stack.peekLast().right;

                if (node == null) {
                    node = stack.pollLast();
                    result.add(node.val);

                    while (!stack.isEmpty() && node == stack.peekLast().right) {
                        node = stack.pollLast();
                        result.add(node.val);
                    }
                } else {
                    root = node;
                }
            }
        }
        return result;
    }

    public static void postorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorderTraversalRecursive(root.left, res);
        postorderTraversalRecursive(root.right, res);
        res.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        postorderTraversalRecursive(root, result);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> answer = postorderTraversal(root);

        System.out.println(answer);
    }
}