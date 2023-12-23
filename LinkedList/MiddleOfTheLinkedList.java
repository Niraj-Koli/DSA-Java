/*
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
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

public class MiddleOfTheLinkedList {
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

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);

        ListNode answer = middleNode(head);

        printLL(answer);
    }
}

// class Solution {
// public ListNode middleNode(ListNode head) {
// int cnt = 0;
// ListNode head1 = head;
// while (head1 != null) {
// head1 = head1.next;
// cnt++;
// }
// cnt = (cnt + 1) % 2 == 0 ? (cnt + 1) / 2 : cnt / 2 + 1;
// int cnt2 = 0;
// while (head != null) {
// cnt2++;
// if (cnt2 == cnt) {
// break;
// }
// head = head.next;
// }
// return head;
// }
// }