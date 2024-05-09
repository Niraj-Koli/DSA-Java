/*
 * Given the root of a binary tree, the value of a target node target, and an
 * integer k, return an array of the values of all nodes that have a distance k
 * from the target node.
 * 
 * You can return the answer in any order.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class AllNodesDistanceKInBinaryTree {
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

    // Time -> O(n) //
    // Space -> O(n) //

    private static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentsMap) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parentsMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentsMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentsMap = new HashMap<TreeNode, TreeNode>();

        markParents(root, parentsMap);

        HashMap<TreeNode, Boolean> vis = new HashMap<TreeNode, Boolean>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(target);

        vis.put(target, true);

        int distance = 0;

        while (!queue.isEmpty()) {
            if (distance == k) {
                break;
            }

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && vis.get(node.left) == null) {
                    vis.put(node.left, true);
                    queue.offer(node.left);
                }

                if (node.right != null && vis.get(node.right) == null) {
                    vis.put(node.right, true);
                    queue.offer(node.right);
                }

                if (parentsMap.get(node) != null && vis.get(parentsMap.get(node)) == null) {
                    vis.put(parentsMap.get(node), true);
                    queue.offer(parentsMap.get(node));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            res.add(queue.poll().data);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode target = root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        int k = 2;

        System.out.println(distanceK(root, target, k));
    }
}