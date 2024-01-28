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
import java.util.List;
import java.util.Map;
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

class NodePair {
    TreeNode node;
    int state;

    NodePair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class BottomViewOfBinaryTree {
    public static List<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        ArrayDeque<NodePair> queue = new ArrayDeque<NodePair>();

        queue.offer(new NodePair(root, 0));

        while (!queue.isEmpty()) {
            NodePair pair = queue.poll();

            TreeNode node = pair.node;
            int state = pair.state;

            map.put(state, node.val);

            if (node.left != null) {
                queue.offer(new NodePair(node.left, state - 1));
            }

            if (node.right != null) {
                queue.offer(new NodePair(node.right, state + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
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

        List<Integer> answer = bottomView(root);

        System.out.println(answer);
    }
}