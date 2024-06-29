/*
 * Given the root of a binary tree, calculate the vertical order traversal of
 * the binary tree.
 * 
 * For each node at position (row, col), its left and right children will be at
 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
 * the tree is at (0, 0).
 * 
 * The vertical order traversal of a binary tree is a res of top-to-bottom
 * orderings for each column index starting from the leftmost column and ending
 * on the rightmost column. There may be multiple nodes in the same row and same
 * column. In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

class VerticalOrderTraversal {
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

    private static class Tuple {
        private TreeNode node;
        private int row;
        private int col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();

        ArrayDeque<Tuple> queue = new ArrayDeque<Tuple>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<Integer>());
            }

            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (TreeMap<Integer, PriorityQueue<Integer>> depth : map.values()) {
            res.add(new ArrayList<Integer>());

            for (PriorityQueue<Integer> nodes : depth.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }
}