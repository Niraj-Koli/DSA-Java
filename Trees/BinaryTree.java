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

public class BinaryTree {

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static TreeNode arrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = null;

        for (int num : nums) {
            root = insert(root, num);
        }

        return root;
    }

    public static void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }

    public static void printPostOrder(TreeNode node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2, 5 };

        TreeNode root = arrayToBST(nums);

        printPreOrder(root);
        System.out.println();

        printInOrder(root);
        System.out.println();

        printPostOrder(root);
        System.out.println();
    }
}
