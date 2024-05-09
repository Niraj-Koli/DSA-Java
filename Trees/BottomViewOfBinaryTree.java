/*
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree
 * from bottom.
 * 
 * 20
 * / \
 * 8 22
 * / \ \
 * 5 3 25
 * / \
 * 10 14
 * 
 * For the above tree, the bottom view is 5 10 3 14 25.
 * If there are multiple bottom-most nodes for a horizontal distance from root,
 * then print the later one in level traversal. For example, in the below
 * diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we
 * need to print 4.
 * 
 * 20
 * / \
 * 8 22
 * / \ / \
 * 5 3 4 25
 * / \
 * 10 14
 * 
 * For the above tree the output should be 5 10 4 14 25.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class BottomViewOfBinaryTree {
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

    private static class Pair {
        private TreeNode node;
        private int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            TreeNode node = pair.node;
            int state = pair.state;

            map.put(state, node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, state - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, state + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(bottomView(root));
    }
}