/*
 * Given the root of a binary tree, return the maximum width of the given tree.
 * 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes that would be present in a complete binary tree extending down to
 * that level are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of a 32-bit signed
 * integer.
 */

import java.util.ArrayDeque;

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

class NodePair {
    TreeNode node;
    int state;

    NodePair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class MaximumWidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        ArrayDeque<NodePair> queue = new ArrayDeque<NodePair>();
        queue.offer(new NodePair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().state;

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek().node;
                int state = queue.peek().state - min;

                queue.poll();

                if (i == 0) {
                    first = state;
                }

                if (i == size - 1) {
                    last = state;
                }

                if (node.left != null) {
                    queue.offer(new NodePair(node.left, state * 2 + 1));
                }

                if (node.right != null) {
                    queue.offer(new NodePair(node.right, state * 2 + 2));
                }
            }

            result = Math.max(result, last - first + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        int answer = widthOfBinaryTree(root);

        System.out.println(answer);
    }
}

// class Solution {
// int maxWidth;

// public int widthOfBinaryTree(TreeNode root) {
// if (root == null) {
// return 0;
// }
// maxWidth = 1;
// ArrayList<Integer> leftMostIndex = new ArrayList<>();
// dfsHelper(root, 1, 0, leftMostIndex);
// return maxWidth;
// }

// private void dfsHelper(TreeNode root, int index, int lvl, ArrayList<Integer>
// leftMostIndex) {
// if (root == null) {
// return;
// }

// if (leftMostIndex.size() <= lvl) {
// leftMostIndex.add(index);
// } else {
// maxWidth = Math.max(maxWidth, index - leftMostIndex.get(lvl) + 1);
// }

// dfsHelper(root.left, index * 2 - 1, lvl + 1, leftMostIndex);
// dfsHelper(root.right, index * 2, lvl + 1, leftMostIndex);
// }
// }