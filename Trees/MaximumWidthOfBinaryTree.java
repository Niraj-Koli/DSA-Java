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

class MaximumWidthOfBinaryTree {
    static class TreeNode {
        public int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static class Pair {
        private TreeNode node;
        private int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().state;

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                
                TreeNode node = pair.node;
                int state = pair.state - min;

                if (i == 0) {
                    first = state;
                }

                if (i == size - 1) {
                    last = state;
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, state * 2 + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, state * 2 + 2));
                }
            }

            res = Math.max(res, last - first + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }
}