import java.util.ArrayDeque;
import java.util.ArrayList;

class AllOrderTraversals {
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

    private static class Pair {
        private TreeNode node;
        private int number;

        public Pair(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void allOrderTraversal(TreeNode root, ArrayList<Integer> pre, ArrayList<Integer> in,
            ArrayList<Integer> post) {
        if (root == null) {
            return;
        }

        ArrayDeque<Pair> stack = new ArrayDeque<Pair>();
        stack.offer(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair element = stack.pollLast();

            if (element.number == 1) {
                pre.add(element.node.data);

                element.number++;
                stack.offer(element);

                if (element.node.left != null) {
                    stack.offer(new Pair(element.node.left, 1));
                }
            } else if (element.number == 2) {
                in.add(element.node.data);

                element.number++;
                stack.offer(element);

                if (element.node.right != null) {
                    stack.offer(new Pair(element.node.right, 1));
                }
            } else {
                post.add(element.node.data);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<Integer> post = new ArrayList<Integer>();

        allOrderTraversal(root, pre, in, post);

        System.out.print("Preorder Traversal: ");
        System.out.println(pre);

        System.out.print("Inorder Traversal: ");
        System.out.println(in);

        System.out.print("Postorder Traversal: ");
        System.out.println(post);
    }
}