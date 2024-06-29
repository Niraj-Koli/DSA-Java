class BinarySearchTree {
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

    // Time -> O(log(n)) //
    // Space -> O(log(n)) //

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static TreeNode arrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = null;

        for (int num : nums) {
            root = insert(root, num);
        }

        return root;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void printPostOrder(TreeNode node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
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
