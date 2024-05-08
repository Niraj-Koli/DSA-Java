/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

import java.util.PriorityQueue;

class MergeKSortedLists {
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode convertArrayToLL(int[] arr) {
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

    private static void printLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return lists[start];
        } else {
            int mid = start + (end - start) / 2;

            ListNode left = mergeLists(lists, start, mid);
            ListNode right = mergeLists(lists, mid + 1, end);

            return mergeTwoLists(left, right);
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;

            if (tail.next != null) {
                minHeap.offer(tail.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] arrs = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };

        int n = arrs.length;

        ListNode[] lists = new ListNode[n];
        ListNode[] LISTS = new ListNode[n];

        for (int i = 0; i < n; i++) {
            lists[i] = convertArrayToLL(arrs[i]);
            LISTS[i] = convertArrayToLL(arrs[i]);
        }

        printLL(mergeKLists(lists));
        printLL(mergeLists(LISTS, 0, LISTS.length - 1));
    }
}