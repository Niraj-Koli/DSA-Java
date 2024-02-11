/*
 * Given the root of a binary tree, calculate the vertical order traversal of
 * the binary tree.
 * 
 * For each node at position (row, col), its left and right children will be at
 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
 * the tree is at (0, 0).
 * 
 * The vertical order traversal of a binary tree is a list of top-to-bottom
 * orderings for each column index starting from the leftmost column and ending
 * on the rightmost column. There may be multiple nodes in the same row and same
 * column. In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();

        ArrayDeque<Tuple> queue = new ArrayDeque<Tuple>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (TreeMap<Integer, PriorityQueue<Integer>> yDepth : map.values()) {
            list.add(new ArrayList<>());

            for (PriorityQueue<Integer> nodes : yDepth.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> answer = verticalTraversal(root);

        System.out.println(answer);
    }
}

// class Solution {
// public List<List<Integer>> verticalTraversal(TreeNode root) {
// return new MyList(root);
// }

// static class MyList extends ArrayList<List<Integer>> {
// TreeNode root;

// public MyList(TreeNode treeNode) {
// this.root = treeNode;
// }

// public int size() {
// method();
// return super.size();
// }

// private void method() {
// if (root == null)
// return;
// HashMap<Integer, List<Info>> map = new HashMap<>();
// int minCol = method(root, map, 0, 0);
// int size = map.size() + minCol;
// List<List<Integer>> list = this;
// while (minCol < size) {
// List<Info> infos = map.get(minCol++);
// List<Integer> subRes = new ArrayList<>();
// list.add(subRes);
// infos.sort(Info::compareTo);
// for (Info i : infos)
// subRes.add(i.val);
// }
// root = null;
// }

// public int method(TreeNode node, HashMap<Integer, List<Info>> map, int row,
// int col) {
// if (node == null)
// return 0;
// if (map.containsKey(col))
// map.get(col).add(new Info(row, node.val));
// else {
// ArrayList<Info> list = new ArrayList<>();
// list.add(new Info(row, node.val));
// map.put(col, list);
// }
// return Math.min(Math.min(method(node.left, map, row - 1, col - 1), col),
// method(node.right, map, row - 1, col + 1));
// }
// }

// static class Info implements Comparable<Info> {
// private final int row;
// public final int val;

// public int compareTo(Info that) {
// return this.row == that.row ? this.val - that.val : that.row - this.row;
// }

// public Info(int row, int val) {
// this.row = row;
// this.val = val;
// }
// }
// }