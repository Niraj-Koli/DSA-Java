/*
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
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

public class RemoveNthNodeFromEndOfList {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();

        temp.next = head;

        ListNode fast = temp;
        ListNode slow = temp;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return temp.next;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);
        int n = 2;

        ListNode answer = removeNthFromEnd(head, n);

        printLL(answer);
    }
}

// class Solution {
// public static int lengthOfLL(ListNode head) {
// ListNode temp = head;

// int length = 0;

// while (temp != null) {
// temp = temp.next;
// length++;
// }

// return length;
// }

// public static ListNode removeKthElement(ListNode head, int k) {
// if (head == null) {
// return head;
// }

// if (k == 1) {
// return head.next;
// }

// int count = 0;

// ListNode temp = head;
// ListNode prev = null;

// while (temp != null) {
// count++;

// if (count == k) {
// prev.next = prev.next.next;
// break;
// }

// prev = temp;
// temp = temp.next;
// }
// return head;
// }

// public static ListNode removeNthFromEnd(ListNode head, int n) {
// int length = lengthOfLL(head);
// int k = length + 1 - n;

// return removeKthElement(head, k);
// }
// }

// class Solution {
// public ListNode removeNthFromEnd(ListNode head, int n) {
// ListNode temp = new ListNode(-1);
// ListNode prev = temp;
// temp.next = head;
// int length = 1;
// if (head == null) {
// return null;
// }
// ListNode curr = head;
// while (curr != null) {
// curr = curr.next;
// length++;
// }
// for (int i = 0; i < length - n; i++) {
// if (i == length - n - 1) {
// ListNode ptr = prev.next.next;
// prev.next = ptr;
// continue;
// }
// prev = prev.next;
// }
// return temp.next;
// }
// }