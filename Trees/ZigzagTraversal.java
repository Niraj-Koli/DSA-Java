/*
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

public class ZigzagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subList = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                subList.add(node.val);
            }

            if (!leftToRight) {
                Collections.reverse(subList);
            }

            leftToRight = !leftToRight;

            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> answer = zigzagLevelOrder(root);

        System.out.println(answer);
    }
}

// class Solution {
// List<List<Integer>> result = new ArrayList<>();

// public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
// if (root != null) {
// dfs(root, 0);
// }
// return result;
// }

// public void dfs(TreeNode root, int level) {
// if (root != null) {
// if (level >= result.size()) {
// List<Integer> list = new ArrayList<>();
// list.add(root.val);
// result.add(list);
// } else {
// if (level % 2 == 0) {
// result.get(level).add(root.val);
// } else {
// result.get(level).add(0, root.val);
// }
// }
// dfs(root.left, level + 1);
// dfs(root.right, level + 1);
// }
// }
// }