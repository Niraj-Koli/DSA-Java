/*
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
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

public class ReverseALinkedList {
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

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);

        ListNode newHead = reverseListIterative(head);

        printLL(newHead);
    }
}