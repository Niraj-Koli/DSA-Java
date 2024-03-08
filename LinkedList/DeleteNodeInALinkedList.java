/*
 * There is a singly-linked list head and we want to delete a node node in it.
 * 
 * You are given the node to be deleted node. You will not be given access to
 * the first node of head.
 * 
 * All the values of the linked list are unique, and it is guaranteed that the
 * given node node is not the last node in the linked list.
 * 
 * Delete the given node. Note that by deleting the node, we do not mean
 * removing it from memory. We mean:
 * 
 * The value of the given node should not exist in the linked list.
 * The number of nodes in the linked list should decrease by one.
 * All the values before node should be in the same order.
 * All the values after node should be in the same order.
 * Custom testing:
 * 
 * For the input, you should provide the entire linked list head and the node to
 * be given node. node should not be the last node of the list and should be an
 * actual node in the list.
 * We will build the linked list and pass the node to your function.
 * The output will be the entire list after calling your function.
 */

public class DeleteNodeInALinkedList {
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode convertArrayToLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Time -> O(1) //
    // Space -> O(1) //

    private static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 9 };

        printLL(convertArrayToLL(arr));

        deleteNode(new ListNode(5));
    }
}