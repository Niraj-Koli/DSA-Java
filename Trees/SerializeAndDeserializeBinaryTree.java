/*
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode serializes
 * a binary tree. You do not necessarily need to follow this format, so please
 * be creative and come up with different approaches yourself.
 */

import java.util.LinkedList;
import java.util.Queue;

class SerializeAndDeserializeBinaryTree {
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

    private static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder res = new StringBuilder();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.data + " ");

            queue.offer(node.left);
            queue.offer(node.right);
        }
        return res.toString();
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();

            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }

            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    private static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String string = serialize(root);

        System.out.println(string);

        TreeNode answer = deserialize(string);

        inOrder(answer);
    }
}