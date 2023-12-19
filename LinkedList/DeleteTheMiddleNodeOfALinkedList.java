/*
 * You are given the head of a linked list. Delete the middle node, and return
 * the head of the modified linked list.
 * 
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the
 * start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than
 * or equal to x.
 * 
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2,
 * respectively.
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

public class DeleteTheMiddleNodeOfALinkedList {
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

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 7, 1, 2, 6 };

        ListNode head = convertArrayToLL(arr);

        ListNode answer = deleteMiddle(head);

        printLL(answer);
    }
}

// class Solution {
// public ListNode deleteMiddle(ListNode head) {
// if (head.next == null)
// return null;
// ListNode slow = head;
// ListNode fast = head;
// ListNode prev = null;
// while (fast != null && fast.next != null) {
// prev = slow;
// slow = slow.next;
// fast = fast.next.next;
// }
// prev.next = prev.next.next;
// return head;
// }
// }