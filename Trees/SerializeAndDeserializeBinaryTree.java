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

public class SerializeAndDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("n ");
                continue;
            }

            result.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return result.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();

            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
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

// public class Codec {

// public String serialize(TreeNode root) {
// StringBuilder sb = new StringBuilder();

// s(root, sb);

// return sb.toString();
// }

// private void s(TreeNode rt, StringBuilder sb) {
// if (rt == null) {
// sb.append("#");
// return;
// }

// sb.append(rt.val).append(".");
// s(rt.left, sb);
// s(rt.right, sb);
// }

// public TreeNode deserialize(String data) {
// AtomicInteger idx = new AtomicInteger(0);

// TreeNode ans = d(data, idx);

// return ans;
// }

// private TreeNode d(String dt, AtomicInteger idx) {
// if (idx.get() >= dt.length()
// || dt.charAt(idx.get()) == '#') {
// idx.getAndIncrement();
// return null;
// }

// TreeNode cur = new TreeNode(number(dt, idx));

// idx.getAndIncrement();

// cur.left = d(dt, idx);
// cur.right = d(dt, idx);

// return cur;
// }

// private int number(String dt, AtomicInteger idx) {
// StringBuilder sb = new StringBuilder();

// while (idx.get() < dt.length()
// && dt.charAt(idx.get()) != '.'
// && dt.charAt(idx.get()) != '#') {
// sb.append(dt.charAt(idx.getAndIncrement()));
// }

// return Integer.valueOf(sb.toString());
// }
// }