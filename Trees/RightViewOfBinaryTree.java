/*
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom
 */

import java.util.ArrayList;
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

public class RightViewOfBinaryTree {
    public static void rightView(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }

        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        rightView(root, 0, result);

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

        List<Integer> answer = rightSideView(root);

        System.out.println(answer);
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> prevLevel = new ArrayList<TreeNode>();
        prevLevel.add(root);
        List<Integer> returnList = new ArrayList<Integer>();
        if (root != null) {
            returnList.add(root.val);
        }
        while (prevLevel.size() > 0) {
            List<TreeNode> currentLevel = new ArrayList<TreeNode>();
            for (TreeNode node : prevLevel) {
                if (node != null) {
                    if (node.left != null) {
                        currentLevel.add(node.left);
                    }
                    if (node.right != null) {
                        currentLevel.add(node.right);
                    }
                }
            }
            if (currentLevel.size() > 0) {
                returnList.add(currentLevel.get(currentLevel.size() - 1).val);
            }
            prevLevel = currentLevel;
        }
        return returnList;
    }
}