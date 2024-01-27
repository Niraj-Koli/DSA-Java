/*
 * You are given the root of a binary tree with unique values, and an integer
 * start. At minute 0, an burning starts from the node with value start.
 * 
 * Each minute, a node becomes burned if:
 * 
 * The node is currently uninfected.
 * The node is adjacent to an burned node.
 * Return the number of minutes needed for the entire tree to be burned.
 */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

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

public class AmountOfTimeToBurnABinaryTreeFromANode {
    public static TreeNode mapParents(TreeNode root, Map<TreeNode, TreeNode> map, int start) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        TreeNode target = new TreeNode(-1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == start) {
                target = node;
            }

            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return target;
    }

    public static int findMinTime(Map<TreeNode, TreeNode> map, TreeNode target) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(target);

        HashMap<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        visited.put(target, true);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.get(node.left) == null) {
                    flag = true;
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }

                if (node.right != null && visited.get(node.right) == null) {
                    flag = true;
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }

                if (map.get(node) != null && visited.get(map.get(node)) == null) {
                    flag = true;
                    visited.put(map.get(node), true);
                    queue.offer(map.get(node));
                }
            }
            if (flag) {
                time++;
            }
        }
        return time;
    }

    public static int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

        TreeNode target = mapParents(root, map, start);

        int time = findMinTime(map, target);

        return time;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        int start = 3;

        int answer = amountOfTime(root, start);

        System.out.println(answer);
    }
}

// class Solution {
// private int ans;

// public int amountOfTime(TreeNode root, int start) {
// dfs(root, start);
// return ans;
// }

// public int dfs(TreeNode root, int start) {
// if (root == null)
// return 0;

// int leftDepth = dfs(root.left, start);
// int rightDepth = dfs(root.right, start);

// if (root.val == start) {
// ans = Math.max(leftDepth, rightDepth);
// return -1;
// } else if (leftDepth >= 0 && rightDepth >= 0) {
// return Math.max(leftDepth, rightDepth) + 1;
// } else {
// ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
// return Math.min(leftDepth, rightDepth) - 1;
// }
// }
// }