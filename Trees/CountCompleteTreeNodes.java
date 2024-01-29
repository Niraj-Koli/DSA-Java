/*
 * Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 */

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

public class CountCompleteTreeNodes {
    public static int getHeightLeft(TreeNode root) {
        int height = 0;

        while (root.left != null) {
            height++;

            root = root.left;
        }
        return height;
    }

    public static int getHeightRight(TreeNode root) {
        int height = 0;

        while (root.right != null) {
            height++;

            root = root.right;
        }
        return height;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightLeft(root);
        int rightHeight = getHeightRight(root);

        if (leftHeight == rightHeight) {
            return ((2 << leftHeight)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int answer = countNodes(root);

        System.out.println(answer);
    }
}

// class Solution {
// public int countNodes(TreeNode root) {
// Queue<TreeNode> queue = new LinkedList<TreeNode>();
// if (root == null)
// return 0;
// queue.offer(root);
// int count = 0;
// while (!queue.isEmpty()) {
// count += queue.size();
// for (int i = queue.size(); i > 0; i--) {
// if (queue.peek().left != null)
// queue.offer(queue.peek().left);
// if (queue.peek().right != null)
// queue.offer(queue.peek().right);
// queue.poll();
// }
// }
// return count;
// }
// }