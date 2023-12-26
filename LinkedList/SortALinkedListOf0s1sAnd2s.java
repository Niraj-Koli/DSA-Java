/*
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s
 * only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros
 * segregate to head side, 2s at the end of the linked list, and 1s in the mid
 * of 0s and 2s.
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

public class SortALinkedListOf0s1sAnd2s {
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

    public static ListNode segregate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroHead = new ListNode();
        ListNode zeroPointer = zeroHead;

        ListNode oneHead = new ListNode();
        ListNode onePointer = oneHead;

        ListNode twoHead = new ListNode();
        ListNode twoPointer = twoHead;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                zeroHead.next = temp;
                zeroHead = temp;
            } else if (temp.val == 1) {
                oneHead.next = temp;
                oneHead = temp;
            } else if (temp.val == 2) {
                twoHead.next = temp;
                twoHead = temp;
            }
            temp = temp.next;
        }

        zeroHead.next = (onePointer.next != null) ? (onePointer.next) : (twoPointer.next);

        oneHead.next = twoPointer.next;

        twoHead.next = null;

        ListNode newHead = zeroPointer.next;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 2, 0, 2, 2 };

        ListNode head = convertArrayToLL(arr);

        ListNode answer = segregate(head);

        printLL(answer);
    }
}