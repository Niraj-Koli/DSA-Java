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
import java.util.List;
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

public class AllNodesDistanceKInBinaryTree {
    public static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentsMap) {
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

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<TreeNode, TreeNode>();

        markParents(root, parentsMap);

        HashMap<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(target);

        visited.put(target, true);

        int distance = 0;

        while (!queue.isEmpty()) {
            if (distance == k) {
                break;
            }

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.get(node.left) == null) {
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }

                if (node.right != null && visited.get(node.right) == null) {
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }

                if (parentsMap.get(node) != null && visited.get(parentsMap.get(node)) == null) {
                    visited.put(parentsMap.get(node), true);
                    queue.offer(parentsMap.get(node));
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
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

        List<Integer> answer = distanceK(root, target, k);

        System.out.println(answer);
    }
}

// class Solution {

// public static void NodesinKdistance2(TreeNode root, List<Integer> arr, int k,
// int n) {

// if (root == null) {
// return;
// }
// if (k == n) {
// int a = root.val;
// arr.add(a);
// return;
// }
// NodesinKdistance2(root.left, arr, k, n + 1);
// NodesinKdistance2(root.right, arr, k, n + 1);
// return;
// }

// public static int NodesinKdistance3(TreeNode root, TreeNode target,
// List<Integer> arr, int k) {

// if (root == null) {
// return -1;
// }
// if (root.val == target.val) {
// return 0;
// }
// int first = NodesinKdistance3(root.left, target, arr, k);
// int second = NodesinKdistance3(root.right, target, arr, k);
// if (first >= 0) {
// if (k - first - 1 == 0) {
// arr.add(root.val);
// return -1;
// }
// NodesinKdistance2(root.right, arr, k - first - 2, 0);
// return first + 1;
// }
// if (second >= 0) {
// if (k - second - 1 == 0) {
// arr.add(root.val);
// return -1;
// }
// NodesinKdistance2(root.left, arr, k - second - 2, 0);
// return second + 1;
// }
// return -1;
// }

// public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
// List<Integer> arr = new ArrayList<>();
// NodesinKdistance2(target, arr, k, 0);
// NodesinKdistance3(root, target, arr, k);
// return arr;
// }
// }