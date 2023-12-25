/* Given the head of a linked list, rotate the list to the right by k places. */

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

public class RotateList {
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

    public static ListNode findNthNode(ListNode temp, int k) {
        int count = 1;

        while (temp != null) {
            if (count == k) {
                return temp;
            }

            count++;

            temp = temp.next;
        }

        return temp;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0) {
            return head;
        }

        k = k % len;

        tail.next = head;

        ListNode newTail = findNthNode(head, len - k);

        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertArrayToLL(arr);
        int k = 2;

        ListNode answer = rotateRight(head, k);

        printLL(answer);
    }
}

// class Solution {
// public ListNode rotateRight(ListNode head, int k) {
// if (head == null || head.next == null) {
// return head;
// }
// int n = 0;
// ListNode cur = head;
// ListNode tail = head;
// while (cur != null) {
// n++;
// tail = cur;
// cur = cur.next;
// }

// k = k % n;

// if (k == 0) {
// return head;
// }
// ListNode newTail = null;
// ListNode newHead = head;
// int step = n - k;
// for (int i = 0; i < step; i++) {
// newTail = newHead;
// newHead = newHead.next;
// }
// newTail.next = null;
// tail.next = head;
// return newHead;
// }
// }