import java.util.ArrayDeque;
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

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class AllOrderTraversals {
    public static void allOrderTraversal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        ArrayDeque<Pair> stack = new ArrayDeque<Pair>();

        stack.offerLast(new Pair(root, 1));

        if (root == null) {
            return;
        }

        while (!stack.isEmpty()) {
            Pair element = stack.pollLast();

            if (element.num == 1) {
                pre.add(element.node.val);

                element.num++;
                stack.offerLast(element);

                if (element.node.left != null) {
                    stack.offerLast(new Pair(element.node.left, 1));
                }
            } else if (element.num == 2) {
                in.add(element.node.val);

                element.num++;
                stack.offerLast(element);

                if (element.node.right != null) {
                    stack.offerLast(new Pair(element.node.right, 1));
                }
            } else {
                post.add(element.node.val);
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

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        allOrderTraversal(root, pre, in, post);

        System.out.print("Preorder Traversal: ");
        System.out.println(pre);

        System.out.print("Inorder Traversal: ");
        System.out.println(in);

        System.out.print("Postorder Traversal: ");
        System.out.println(post);
    }
}