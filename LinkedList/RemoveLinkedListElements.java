/*
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has ListNode.val == val, and return the new head.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveLinkedListElements {
    public static ListNode convertArrayToLL(int[] arr) {
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

    public static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.val == val) {
                if (prev != null) {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1 };

        ListNode head = convertArrayToLL(arr);
        int val = 2;

        ListNode list = removeElements(head, val);

        printLL(list);
    }
}

// class Solution {
// public ListNode removeElements(ListNode head, int val) {
// if (head == null)
// return null;

// return recursive(head, val);
// }

// public ListNode recursive(ListNode node, int val) {
// if (node == null)
// return null;
// if (node.val == val)
// return recursive(node.next, val);
// node.next = recursive(node.next, val);
// return node;
// }
// }