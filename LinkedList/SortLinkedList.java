/*
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
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

public class SortLinkedList {
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
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode dummy = new ListNode(-1);

        ListNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }
        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = middleNode(head);

        ListNode rightNode = middle.next;
        middle.next = null;

        ListNode leftList = sortList(head);
        ListNode rightList = sortList(rightNode);

        return mergeTwoLists(leftList, rightList);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 5, 3, 4, 0 };

        ListNode root = convertArrayToLL(arr);

        printLL(root);

        ListNode answer = sortList(root);

        printLL(answer);
    }
}

// public class Solution {
// public ListNode sortList(ListNode head) {
// return sortList(head, null);
// }

// private ListNode sortList(ListNode start, ListNode end) {
// if (start == null || start.next == null || start == end) {
// return start;
// }

// int pivot = start.val;
// ListNode left = start;
// ListNode right = start;
// ListNode curr = start.next;
// boolean sorted = true;

// while (curr != null && curr != end) {
// ListNode temp = curr.next;
// if (curr.val < pivot) {
// sorted = false;
// curr.next = left;
// left = curr;
// right.next = temp;
// } else if (curr.val < right.val) {
// sorted = false;
// right = curr;
// } else {
// right = curr;
// }
// curr = temp;
// }
// if (sorted) {
// return start;
// }

// start.next = sortList(start.next, end);
// left = sortList(left, start);
// return left;
// }
// }