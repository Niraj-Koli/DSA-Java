/*
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
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

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTree = maxDepth(root.left);
        int rightSubTree = maxDepth(root.right);

        return (1 + Math.max(leftSubTree, rightSubTree));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int answer = maxDepth(root);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxDepth(TreeNode root) {
// if (root == null)
// return 0;
// Queue<TreeNode> queue = new LinkedList<>();
// queue.offer(root);
// int result = 0;
// while (!queue.isEmpty()) {
// result++;
// int size = queue.size();
// for (int i = 0; i < size; i++) {
// TreeNode node = queue.poll();
// if (node.left != null)
// queue.offer(node.left);
// if (node.right != null)
// queue.offer(node.right);
// }
// }
// return result;
// }
// }