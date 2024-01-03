/*
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
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

public class MergeTwoSortedLists {
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

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4 };
        int[] arr2 = { 1, 3, 4 };

        ListNode list1 = convertArrayToLL(arr1);
        ListNode list2 = convertArrayToLL(arr2);

        ListNode answer = mergeTwoLists(list1, list2);

        printLL(answer);
    }
}

// class Solution {
// public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
// if (list1 != null && list2 != null) {
// if (list1.val < list2.val) {
// list1.next = mergeTwoLists(list1.next, list2);
// return list1;
// } else {
// list2.next = mergeTwoLists(list1, list2.next);
// return list2;
// }
// }
// if (list1 == null) {
// return list2;
// }
// return list1;

// }
// }