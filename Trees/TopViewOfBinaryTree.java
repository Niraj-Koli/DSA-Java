/*
 * Given below is a binary tree. The task is to print the top view of binary
 * tree. Top view of a binary tree is the set of nodes visible when the tree is
 * viewed from the top. For the given below tree
 * 
 * 1
 * / \
 * 2 3
 * / \ / \
 * 4 5 6 7
 * 
 * Top view will be: 4 2 1 3 7
 * Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are
 * outside the shadow of the tree and are at same position then consider the
 * left ones only(i.e. leftmost).
 */

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

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

public class TopViewOfBinaryTree {
    public static int levelOrderTraversal(TreeNode root, HashMap<Integer, Integer> map) {
        ArrayDeque<NodePair> queue = new ArrayDeque<NodePair>();

        queue.offer(new NodePair(root, 0));

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            NodePair pair = queue.poll();

            TreeNode node = pair.node;
            int state = pair.state;

            min = Math.min(min, state);

            if (!map.containsKey(state)) {
                map.put(state, node.val);
            }

            if (node.left != null) {
                queue.offer(new NodePair(node.left, state - 1));
            }

            if (node.right != null) {
                queue.offer(new NodePair(node.right, state + 1));
            }
        }
        return min;
    }

    public static List<Integer> topView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int min = levelOrderTraversal(root, map);

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = min; map.containsKey(i); i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> answer = topView(root);

        System.out.println(answer);
    }
}