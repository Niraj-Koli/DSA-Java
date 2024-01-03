/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

import java.util.PriorityQueue;

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

public class MergeKSortedLists {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if (node.next != null) {
                minHeap.offer(node.next);
            }

            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] arrs = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };

        int n = arrs.length;

        ListNode[] lists = new ListNode[n];

        for (int i = 0; i < n; i++) {
            lists[i] = convertArrayToLL(arrs[i]);
        }

        ListNode answer = mergeKLists(lists);

        printLL(answer);
    }
}

// class Solution {
// public ListNode mergeKLists(ListNode[] lists) {
// if (lists == null || lists.length == 0) {
// return null;
// }
// return mergeKListsHelper(lists, 0, lists.length - 1);
// }

// private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
// if (start == end) {
// return lists[start];
// }
// if (start + 1 == end) {
// return merge(lists[start], lists[end]);
// }
// int mid = start + (end - start) / 2;
// ListNode left = mergeKListsHelper(lists, start, mid);
// ListNode right = mergeKListsHelper(lists, mid + 1, end);
// return merge(left, right);
// }

// private ListNode merge(ListNode l1, ListNode l2) {
// ListNode dummy = new ListNode(0);
// ListNode curr = dummy;

// while (l1 != null && l2 != null) {
// if (l1.val < l2.val) {
// curr.next = l1;
// l1 = l1.next;
// } else {
// curr.next = l2;
// l2 = l2.next;
// }
// curr = curr.next;
// }

// curr.next = (l1 != null) ? l1 : l2;

// return dummy.next;
// }
// }