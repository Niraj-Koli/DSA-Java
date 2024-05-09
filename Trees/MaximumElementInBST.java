class MaximumElementInBST {
    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Time -> O(h) //
    // Space -> O(1) //

    private static int maxValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        System.out.println(maxValue(root));
    }
}
